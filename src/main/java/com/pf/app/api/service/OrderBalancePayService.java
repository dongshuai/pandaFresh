package com.pf.app.api.service;

import com.pf.app.api.exception.OrderException;
import com.pf.app.api.mapper.PfDeliveryMapper;
import com.pf.app.api.mapper.PfGoodsMapper;
import com.pf.app.api.mapper.PfOrderMapper;
import com.pf.app.api.mapper.PfShoppingCartMapper;
import com.pf.app.api.mapper.PfSysConfMapper;
import com.pf.app.api.mapper.PfUserBalanceMapper;
import com.pf.app.api.mapper.PfUserDetailMapper;
import com.pf.app.api.mapper.PfUserMapper;
import com.pf.app.api.mapper.PfUserRedbagMapper;
import com.pf.app.api.mapper.PfUserRedbagRecordMapper;
import com.pf.app.api.mapper.PfUserVoucherMapper;
import com.pf.app.api.mapper.PfUserVoucherRecordMapper;
import com.pf.app.api.model.PfDelivery;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfOrder;
import com.pf.app.api.model.PfShoppingCart;
import com.pf.app.api.model.PfSysConf;
import com.pf.app.api.model.PfUser;
import com.pf.app.api.model.PfUserBalance;
import com.pf.app.api.model.PfUserDetail;
import com.pf.app.api.model.PfUserRedbag;
import com.pf.app.api.model.PfUserRedbagRecord;
import com.pf.app.api.model.PfUserVoucher;
import com.pf.app.api.model.PfUserVoucherRecord;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.util.VerificationExpUtil;
import com.pf.app.api.vo.OrderItem;
import com.pf.app.api.vo.OrderPayVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderBalancePayService extends AbstractService<OrderPayVo> {
    private static final Logger logger = LoggerFactory.getLogger(OrderBalancePayService.class);
    @Autowired
    private PfUserMapper pfUserMapper;
    @Autowired
    private PfGoodsMapper pfGoodsMapper;
    @Autowired
    private PfUserRedbagMapper pfUserRedbagMapper;
    @Autowired
    private PfUserVoucherRecordMapper pfUserVoucherRecordMapper;
    @Autowired
    private PfUserVoucherMapper pfUserVoucherMapper;
    @Autowired
    private PfUserRedbagRecordMapper pfUserRedbagRecordMapper;
    @Autowired
    private PfUserBalanceMapper pfUserBalanceMapper;
    @Autowired
    private PfOrderMapper pfOrderMapper;
    @Autowired
    private PfSysConfMapper pfSysConfMapper;

    @Autowired
    private PfShoppingCartMapper pfShoppingCartMapper;
    @Autowired
    private PfDeliveryMapper pfDeliveryMapper;
    @Autowired
    private PfUserDetailMapper pfUserDetailMapper;


    @Override
    public InterfaceResponse check(OrderPayVo vo) {
        logger.info("订单支付检查参数开始，提交信息：{}", vo);

        if(StringUtils.isBlank(vo.getPassword())){
            return error(8100, "支付密码不能为空");
        }

        if (null == vo.getGoodsIds()) {
            return error(8100, "商品信息不能为空");
        }
        if (vo.getAmount() == null) {
            return error(8101, "订单总费用不能为空");
        }
        if (vo.getPayType() == null) {
            return error(8102, "订单支付类型不能为空");
        }
        logger.info("订单支付检查参数结束");
        return null;
    }

    @Override
    public InterfaceResponse executor(OrderPayVo vo) {
        logger.info("订单支付执行开始");
        Long userId = getUserId();
        PfUser pfUser = pfUserMapper.selectByPrimaryKey(userId);
        Date memberEndDate = pfUser.getMemberEndDate();

        Long deliverFee = vo.getDeliverFee()==null  ?  0L : vo.getDeliverFee();

        PfUserDetail pfUserDetail = pfUserDetailMapper.selectByPrimaryKey(userId);
        if(pfUserDetail == null){
            logger.debug("用户没有设置支付密码，不能购买");
            throw new OrderException("用户没有设置支付密码");
        }
        String payPwd = pfUserDetail.getPayPwd();

        if(payPwd == null){
            logger.debug("用户没有设置支付密码，不能购买");
            throw new OrderException("用户没有设置支付密码");
        }

        if(!StringUtils.equals(payPwd,vo.getPassword())){
            logger.debug("密码错误");
            throw new OrderException("密码错误");
        }


        pfUserDetail.getPayPwd();

        Boolean isMember = false;
        if(memberEndDate != null ){
            isMember = !VerificationExpUtil.isExp(memberEndDate);
        }
        if (!isMember) {
            logger.debug("用户会员过期");
            if (deliverFee.compareTo(0L) <= 0) {
                logger.debug("非会员用户运费为空，不能购买");
                throw new OrderException("非会员不能免运费");
            }
        }


        // 取出订单中商品信息开始
        //List<OrderItem> orderItemsList = new ArrayList<>(10);
        List<Long> goodsIdList = new ArrayList<>(10);
        String goodsIds = vo.getGoodsIds();
        String[] goodsIdArry = goodsIds.split(",");
        for (String goodsId : goodsIdArry) {
            goodsIdList.add(Long.parseLong(goodsId));
        }
        if (goodsIdList.isEmpty()) {
            logger.debug("商品列表为空");
            throw new OrderException("商品为空");
        }
        Example realTimePfShoppingCartExample = new Example(PfShoppingCart.class);
        realTimePfShoppingCartExample.createCriteria().andIn("goodsId",goodsIdList).andEqualTo("userId",userId).andEqualTo("deliveryType",new Byte("1")).andEqualTo("deliveryId",0L);;
        List<PfShoppingCart> realTimePfShoppingCartList = pfShoppingCartMapper.selectByExample(realTimePfShoppingCartExample);

        Example preSaleShoppingCartExample = new Example(PfShoppingCart.class);
        preSaleShoppingCartExample.createCriteria().andIn("goodsId",goodsIdList).andEqualTo("userId",userId).andEqualTo("deliveryType",new Byte("2")).andEqualTo("deliveryId",0L);
        List<PfShoppingCart> preSalePfShoppingCartList = pfShoppingCartMapper.selectByExample(preSaleShoppingCartExample);

        List<PfShoppingCart> pfShoppingCartList = new ArrayList<>(10);
        pfShoppingCartList.addAll(realTimePfShoppingCartList);
        pfShoppingCartList.addAll(preSalePfShoppingCartList);
        if (pfShoppingCartList.isEmpty()) {
            logger.debug("购物车商品为空");
            throw new OrderException("购物车商品为空");
        }

        // 取出订单中商品信息结束

        //计算商总价 开始
        Example example = new Example(PfGoods.class);
        example.createCriteria().andIn("id", goodsIdList);

        List<PfGoods> pfGoodsList = pfGoodsMapper.selectByExample(example);
        Map<Long, PfGoods> pfGoodsMap = new HashMap(pfGoodsList.size());
        for (PfGoods pfGoods : pfGoodsList){
            pfGoodsMap.put(pfGoods.getId(),pfGoods);
        }

        Long totalfee = 0L;//商品总价
        Long realAmount =  0L;//商品实际价格

        //for (PfGoods pfGoods : pfGoodsList) {

            for (PfShoppingCart pfShoppingCart : pfShoppingCartList) {
                PfGoods pfGoods = pfGoodsMap.get(pfShoppingCart.getGoodsId());
                Byte type = pfGoods.getType();
                Long price = pfGoods.getPrice(); //商品原价
                Long realPrice = pfGoods.getRealPrice();//商品实际价格
                Byte priceType = pfGoods.getPriceType();//商品价格类型
                Integer itemAmount = pfShoppingCart.getAmount();
                realAmount = realAmount + price*itemAmount;
                if (priceType.equals(new Byte("4"))) {
                    logger.debug("第二份半价商品：{} ", pfGoods.getName());

                    if (itemAmount % 2 == 0) {
                        logger.debug("购买数量为偶数");
                        totalfee = totalfee + price * itemAmount / 2;
                        totalfee = totalfee + realPrice * itemAmount / 2;
                    } else {
                        logger.debug("购买数量为奇数");
                        totalfee = totalfee + realPrice * (itemAmount - 1) / 2;
                        totalfee = totalfee + price * (itemAmount - 1) / 2;
                        totalfee = totalfee + price;
                    }
                    continue;
                }

                if (priceType.equals(new Byte("3"))) {
                    logger.debug("折扣商品：{} 购买数量：{}", pfGoods.getName(), itemAmount);
                    totalfee = totalfee + realPrice * itemAmount;
                    continue;
                }
                if (priceType.equals(new Byte("2"))) {
                    logger.debug("会员价格商品：{} 购买数量：{}", pfGoods.getName(), itemAmount);
                    if (isMember) {
                        logger.debug("用户是会员");
                        totalfee = totalfee + realPrice * itemAmount;
                    } else {
                        logger.debug("用户不是会员");
                        totalfee = totalfee + price * itemAmount;
                    }
                    continue;
                }

                if (priceType.equals(new Byte("1"))) {
                    logger.debug("正常价格商品");
                    totalfee = totalfee + price * itemAmount;
                    continue;
                }

                logger.error("商品价格类型错误");
                throw new OrderException("商品类型错误");
            }

        //}

        //计算商总价 结束

        // 计算优惠券开始

        Date now = new Date();

        Long voucher = vo.getVoucher();
        Long voucherId = vo.getVoucherId();

        if (voucher != null && voucherId != null) {
            Example pfUserVoucherRecordExample = new Example(PfUserVoucherRecord.class);
            pfUserVoucherRecordExample.createCriteria().andEqualTo("id", voucherId).andEqualTo("userId", userId);

            List<PfUserVoucherRecord> pfUserVoucherRecordList = pfUserVoucherRecordMapper.selectByExample(pfUserVoucherRecordExample);
            if (pfUserVoucherRecordList.isEmpty()) {
                logger.error("用户没有优惠券,却使用了优惠券");
                throw new OrderException("用户没有优惠券，却使用了优惠券");
            }
            PfUserVoucherRecord pfUserVoucherRecord = pfUserVoucherRecordList.get(0);
            Byte useFlag = pfUserVoucherRecord.getUsedFlag();
            if (useFlag != null && !useFlag.equals(new Byte("1"))) {
                logger.error("优惠券已经使用");
                throw new OrderException("优惠券已经使用");
            }
            Date validEndTime = pfUserVoucherRecord.getValidEndTime();
            if (VerificationExpUtil.isExp(validEndTime)) {
                logger.error("优惠券已经过期");
                throw new OrderException("优惠券已经过期");
            }
            Long useCondition = pfUserVoucherRecord.getUseCondition();
            if (useCondition.compareTo(totalfee) == 1) {
                logger.error("优惠券不满足使用条件 目前条件 ：{} 使用条件 ：{}", totalfee, useCondition);
                throw new OrderException("优惠券不满足使用条件");
            }
            Long voucherAmount = pfUserVoucherRecord.getAmount();
            if (voucher.compareTo(voucherAmount) != 0) {
                logger.error("提交优惠券面值错误 提交面值 ：{} 实际面值 ：{}", voucher, voucherAmount);
                throw new OrderException("提交优惠券面值错误");

            }
            totalfee = totalfee - voucherAmount;
            PfUserVoucherRecord voucherRecord = new PfUserVoucherRecord();
            voucherRecord.setId(voucherId);
            voucherRecord.setUsedFlag(new Byte("2"));
            pfUserVoucherRecordMapper.updateByPrimaryKeySelective(voucherRecord);
            PfUserVoucher pfUserVoucher = pfUserVoucherMapper.selectByPrimaryKey(userId);
            pfUserVoucher.setTotalAmount(pfUserVoucher.getTotalAmount() - voucherAmount);
            pfUserVoucher.setLastChangeTime(now);
            pfUserVoucherMapper.updateByPrimaryKey(pfUserVoucher);
        }
        // 计算优惠券结束


        //计算红包开始
        Long redBag = vo.getRedbag();

        if (redBag != null && redBag.compareTo(0L) > 0) {
            logger.debug("用户使用红包");
            PfUserRedbag pfUserRedbag = pfUserRedbagMapper.selectByPrimaryKey(userId);
            Long redbagTotalAmount = pfUserRedbag.getTotalAmount();
            if (redbagTotalAmount == null || redbagTotalAmount.compareTo(0L) <= 0) {
                logger.error("用户没有红包，却使用了红包");
                throw new OrderException("用户没有红包，却使用了红包");
            }
            if (redbagTotalAmount.compareTo(redBag) <= 0) {
                logger.error("用户红包少于用户提交红包");
                throw new OrderException("用户红包少于用户提交红包");
            }
            totalfee = totalfee - redBag;

            pfUserRedbag.setTotalAmount(pfUserRedbag.getTotalAmount() - redBag);
            pfUserRedbag.setLastChangeTime(now);
            pfUserRedbagMapper.updateByPrimaryKey(pfUserRedbag);
            PfUserRedbagRecord redbagRecord = new PfUserRedbagRecord();
            redbagRecord.setAmount(redBag);
            redbagRecord.setCreateTime(now);
            redbagRecord.setGetWay(new Byte("4"));
            redbagRecord.setGetWayExplain("用户消费");
            redbagRecord.setId(IdWorkerFactory.getIdWorker().nextId());
            redbagRecord.setUserId(userId);
            pfUserRedbagRecordMapper.insert(redbagRecord);

        }
        //计算红包结束
        //运费
        if(!isMember){
            Example pfSysConfExample = new Example(PfSysConf.class);
            pfSysConfExample.createCriteria().andEqualTo("type",new Byte("1"));
            List<PfSysConf> pfSysConfList = pfSysConfMapper.selectByExample(example);
            if(pfSysConfList.isEmpty() || pfGoodsList.size()>1){
                logger.error("系统配置运费错误");
                throw new OrderException("系统配置运费错误");
            }
            PfSysConf pfSysConf = pfSysConfList.get(0);
            Long confDeliverFee = pfSysConf.getValue();

            if(confDeliverFee.compareTo(deliverFee)!=0){
                logger.error("提交运费与系统配置运费不一致");
                throw new OrderException("提交运费与系统配置运费不一致");
            }
            totalfee = totalfee + deliverFee;
        }
        if(totalfee.compareTo(vo.getAmount())!=0){
            logger.error("订单计算错误");
            throw new OrderException("订单计算错误");
        }

        //扣除用户钱开始
        Example pfUserBalanceExample = new Example(PfUserBalance.class);
        pfUserBalanceExample.createCriteria().andEqualTo("userId", userId);
        pfUserBalanceExample.setForUpdate(true);
        List<PfUserBalance> pfUserBalanceList = pfUserBalanceMapper.selectByExample(pfUserBalanceExample);
        if(pfUserBalanceList.isEmpty()){
            logger.error("用户余额为空");
            throw new OrderException("用户余额为空");
        }
        PfUserBalance pfUserBalance = pfUserBalanceList.get(0);

        Long userBalanceAmount = pfUserBalance.getTotalAmount();
        userBalanceAmount = userBalanceAmount == null ? 0 : userBalanceAmount;
        int rel = userBalanceAmount.compareTo(totalfee);
        if( userBalanceAmount.compareTo(totalfee)<0){
            logger.error("用户余额不足");
            throw new OrderException("用户余额不足");
        }
        PfUserBalance pfUserBalanceRecord = new PfUserBalance();
        pfUserBalanceRecord.setTotalAmount(userBalanceAmount-totalfee);
        pfUserBalanceMapper.updateByExampleSelective(pfUserBalanceRecord,pfUserBalanceExample);
       //扣除用户钱结束

        //保存订单开始
        Long orderId = IdWorkerFactory.getIdWorker().nextId();
        PfOrder pfOrder = new PfOrder();
        pfOrder.setAmount(totalfee);
        pfOrder.setId(orderId);
        pfOrder.setCreateTime(now);
        pfOrder.setUserId(userId);
        pfOrder.setDealStream(IdWorkerFactory.generateyyyymmddhhMMssSSSAnd2Random()+"");
        pfOrder.setDeliverFee(deliverFee);
        pfOrder.setOrderNum(IdWorkerFactory.generateyyyymmddhhMMssSSSAnd2Random()+"");
        pfOrder.setPayTime(now);
        pfOrder.setRealAmount(realAmount);//商品原价
        pfOrder.setPayType(new Byte("3"));
        pfOrder.setRedbag(redBag);
        pfOrder.setVoucher(voucher);
        pfOrder.setVoucherId(voucherId);
        pfOrderMapper.insertSelective(pfOrder);
        //保存订单结束

        //生成配送单开始

        PfDelivery delivery = new PfDelivery();
        delivery.setUserId(userId);
        delivery.setOrderId(orderId);

        Date arrivalTime = null;
        if (!realTimePfShoppingCartList.isEmpty()){
            logger.debug("生成实时达订单");
            Long deliveryId = IdWorkerFactory.getIdWorker().nextId();
            delivery.setId(deliveryId);
            String realTimeArrivaltime = vo.getRealTimeArrivalTime();
            if(StringUtils.isBlank(realTimeArrivaltime)){
                logger.error("请填写实时达到达时间");
                throw new OrderException("请填写实时达到达时间");
            }

            try {
                arrivalTime =  DateUtils.parseDate(realTimeArrivaltime,"yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                throw new OrderException("实时达到达时间格式错误");
            }

            delivery.setType(new Byte("1"));
            delivery.setArriveTime(arrivalTime);
            for(PfShoppingCart shoppingCart : realTimePfShoppingCartList){
                PfShoppingCart record = new PfShoppingCart();
                record.setId(shoppingCart.getId());
                record.setDeliveryId(deliveryId);
                pfShoppingCartMapper.updateByPrimaryKeySelective(record);
            }
            pfDeliveryMapper.insert(delivery);
        }
        if (!preSalePfShoppingCartList.isEmpty()){
            logger.debug("生成预售订单");
            Long deliveryId = IdWorkerFactory.getIdWorker().nextId();
            delivery.setId(deliveryId);
            String preSaleArrivaltime = vo.getPreSaleArrivalTime();
            if(StringUtils.isBlank(preSaleArrivaltime)){
                logger.error("请填写实时达到达时间");
                throw new OrderException("请填写实时达到达时间");
            }
            String preSaleArrivalTime = vo.getPreSaleArrivalTime();
            try {
                arrivalTime =  DateUtils.parseDate(preSaleArrivalTime,"yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                throw new OrderException("实时达到达时间格式错误");
            }
            delivery.setType(new Byte("2"));
            delivery.setArriveTime(arrivalTime);
            for(PfShoppingCart shoppingCart : preSalePfShoppingCartList){
                PfShoppingCart record = new PfShoppingCart();
                record.setId(shoppingCart.getId());
                record.setDeliveryId(deliveryId);
                pfShoppingCartMapper.updateByPrimaryKeySelective(record);
            }
            pfDeliveryMapper.insert(delivery);
        }
        //生成配送单结束

        return success();
    }









}
