package com.pf.app.api.service;

import com.pf.app.api.mapper.PfGoodsMapper;
import com.pf.app.api.mapper.PfShoppingCartMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfShoppingCart;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.vo.ShoppingCardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
@Service
public class AddShoppingCardService extends AbstractService<ShoppingCardVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(AddShoppingCardService.class);
    /**
     * 购物车mapper
     */
    @Resource
    private PfShoppingCartMapper pfShoppingCartMapper;
    /**
     * 商品mapper
     */
    @Resource
    private PfGoodsMapper pfGoodsMapper;

    @Override
    public InterfaceResponse check(ShoppingCardVo vo) {
        if(vo.getGoodsId() == null){
            return error(1800,"商品id不能为空");
        }
        return null;
    }

    @Override
    public InterfaceResponse executor(ShoppingCardVo vo) {

        logger.info("添加商品到购物车开始");

        Long userId = getUserId();

        Integer amount = vo.getAmount();
        Long goodsId = vo.getGoodsId();

        PfGoods pfGoods = pfGoodsMapper.selectByPrimaryKey(goodsId);
        if(pfGoods == null){
            logger.debug("商品不存在");
            return error(1801,"商品不存在");
        }
        if(amount == null){
            logger.debug("商品数量信息没有传入,默认1");
            amount = 1;
        }

        Example example = new Example(PfShoppingCart.class);
        example.createCriteria().andEqualTo("userId",userId).andEqualTo("goodsId",goodsId);
        PfShoppingCart psc = pfShoppingCartMapper.selectOneByExample(example);
        if(psc!=null){
            logger.debug("商品已经在购物车内，更新商品数量");
            PfShoppingCart entity = new PfShoppingCart();
            entity.setAmount(psc.getAmount()+amount);
            pfShoppingCartMapper.updateByExampleSelective(entity,example);
        }else {
            logger.debug("商品首次添加都购物车内");
            PfShoppingCart pfShoppingCart = new PfShoppingCart();
            pfShoppingCart.setUserId(userId);
            pfShoppingCart.setGoodsId(goodsId);
            pfShoppingCart.setGoodsName(pfGoods.getName());
            pfShoppingCart.setDeliveryType(pfGoods.getDeliveryType());
            pfShoppingCart.setAmount(amount);
            pfShoppingCart.setId(IdWorkerFactory.getIdWorker().nextId());
            pfShoppingCartMapper.insertSelective(pfShoppingCart);
        }
        logger.info("添加商品到购物车结束");
        return success();
    }
}
