package com.pf.app.api.service;

import com.pf.app.api.mapper.PfPhoneCodeMapper;
import com.pf.app.api.mapper.PfThirdPartyLoginInfoMapper;
import com.pf.app.api.mapper.PfUserBalanceMapper;
import com.pf.app.api.mapper.PfUserMapper;
import com.pf.app.api.mapper.PfUserRedbagMapper;
import com.pf.app.api.mapper.PfUserVoucherMapper;
import com.pf.app.api.model.PfPhoneCode;
import com.pf.app.api.model.PfThirdPartyLoginInfo;
import com.pf.app.api.model.PfUser;
import com.pf.app.api.model.PfUserBalance;
import com.pf.app.api.model.PfUserRedbag;
import com.pf.app.api.model.PfUserVoucher;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.util.JwtUtil;
import com.pf.app.api.util.ValidatorUtil;
import com.pf.app.api.util.VerificationExpUtil;
import com.pf.app.api.vo.ThirdPartyBindVo;
import com.pf.app.api.vo.ThirdPartyLoginVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class ThirdPartyBindService extends AbstractService<ThirdPartyBindVo> {

    @Resource
    private PfPhoneCodeMapper pfPhoneCodeMapper;

    @Resource
    private PfThirdPartyLoginInfoMapper pfThirdPartyLoginInfoMapper;
    @Resource
    private PfUserMapper pfUserMapper;
    @Resource
    private PfUserVoucherMapper pfUserVoucherMapper;

    @Resource
    private PfUserBalanceMapper pfUserBalanceMapper;
    @Resource
    private PfUserRedbagMapper pfUserRedbagMapper;

    @Override
    public InterfaceResponse check(ThirdPartyBindVo vo) {
        logger.info("用户登录参数验证开始");

        if (!ValidatorUtil.isMobile(vo.getPhoneNum())) {
            return error(1000, "手机号错误");
        }
        if (StringUtils.isBlank(vo.getVerificationCode())) {
            return error(1000, "验证码错误");
        }
        if("0".equals(vo.getType()+"")){//微信
            if (null == vo.getUnionid() || "".equals(vo.getUnionid())) {
                return error(3001,"参数Unionid不能为空");
            }
            if(null== vo.getOpenid() || "".equals(vo.getOpenid())){
                return error(3002,"参数Openid不能为空");
            }
        }else if("1".equals(vo.getType()+"")){//QQ
            if(null== vo.getUid() || "".equals(vo.getUid())){
                return error(3003,"参数Uid不能为空");
            }
            if(null== vo.getOpenid() || "".equals(vo.getOpenid())){
                return error(3004,"参数Openid不能为空");
            }
        }else if("2".equals(vo.getType()+"")){//微博
            if(null== vo.getUid() || "".equals(vo.getUid())){
                return error(3005,"参数Uid不能为空");
            }
        }else{
            logger.error("第三方登录otherType错误：UserOtherVo={}",vo.toString());
            return error(3006,"第三方用户类型错误");
        }


        logger.info("用户登录参数验证结束");
        return null;
    }

    @Override
    public InterfaceResponse executor(ThirdPartyBindVo vo) {

        logger.info("用户登录执行开始");

        String phoneNum = vo.getPhoneNum();
        PfPhoneCode pfPhoneCode = pfPhoneCodeMapper.selectByPrimaryKey(phoneNum);
        String verificationCode = vo.getVerificationCode();
        if (pfPhoneCode == null) {
            logger.debug("用户验证码不正确");
            return error(1000, "验证码错误");
        }
        Date expDate = DateUtils.addMinutes(pfPhoneCode.getCreateTime(), pfPhoneCode.getExp());
        if (VerificationExpUtil.isExp(expDate)) {
            logger.debug("用户验证码过期");
            return error(1000, "验证码错误");
        }
        String code = pfPhoneCode.getCode();
        if (!StringUtils.equals(code, verificationCode)) {
            logger.debug("用户验证码错误");
            return error(1000, "验证码错误");
        }

        PfUser pfUser = this.saveUserInfo(vo);


        //之前未授权过，插入表，返回otherId给客户端让用户去注册关联
        PfThirdPartyLoginInfo oth = new PfThirdPartyLoginInfo();
        Long otherId = IdWorkerFactory.getIdWorker().nextId();
        oth.setId(otherId);
        oth.setAccessToken(vo.getAccessToken());
        oth.setCreateTime(new Date());
        oth.setExpiresIn(vo.getExpiresIn());
        oth.setIconUrl(vo.getIconUrl());
        oth.setOpenid(vo.getOpenid());
        oth.setType(new Byte(vo.getType() + ""));
        oth.setRefreshToken(vo.getRefreshToken());
        oth.setUid(vo.getUid());
        oth.setUnionid(vo.getUnionid());
        oth.setUserId(pfUser.getId());
        oth.setUserName(vo.getUserName());
        int ret = pfThirdPartyLoginInfoMapper.insert(oth);
        if (ret == 1) {//请用户绑定手机号
            String token = null;
            long expTime = DateUtils.addDays(new Date(),7).getTime();

            try {
                token = JwtUtil.createJWT(pfUser.getId(), pfUser.getNickname(),
                        expTime);
            } catch (Exception e) {
                e.printStackTrace();
                return error(2000,"系统错误");
            }
            logger.debug("token : {}", token);

            Date now = DateUtils.ceiling(new Date(), Calendar.DATE);

            Date memberEndDate = pfUser.getMemberEndDate();
            if(memberEndDate!=null && now.getTime()<=memberEndDate.getTime()){
                logger.debug("用户是会员，设置会员用户");
                pfUser.setMember(true);
            }else {
                logger.debug("用户不是会员");
                pfUser.setMember(false);
            }
            long userId =pfUser.getId();
            PfUserVoucher pfUserVoucher = pfUserVoucherMapper.selectByPrimaryKey(userId);
            PfUserBalance pfUserBalance = pfUserBalanceMapper.selectByPrimaryKey(userId);
            PfUserRedbag pfUserRedbag = pfUserRedbagMapper.selectByPrimaryKey(userId);

            Map<String,Object> userInfoMap = new HashMap<>(5);
            userInfoMap.put("token",token);
            userInfoMap.put("user",pfUser);
            userInfoMap.put("totalRedbag",pfUserRedbag.getTotalAmount());
            userInfoMap.put("totalBalance",pfUserBalance.getTotalAmount());
            userInfoMap.put("totalVoucher",pfUserVoucher.getTotalAmount());
            logger.info("用户登录执行结束");
            return success(userInfoMap);
        } else {
            logger.error("UserOtherService第三方登录返回数据：系统繁忙");
            return this.error(3008,"系统繁忙");
        }



    }


    private PfUser saveUserInfo(ThirdPartyBindVo vo) {
        String phoneNum = vo.getPhoneNum();
        Long recommendUserId = vo.getRecommendUserId();
        Long userId = IdWorkerFactory.getIdWorker().nextId();
        Date regTime = new Date();
        PfUser pfUser = new PfUser();
        pfUser.setId(userId);
        pfUser.setNickname(vo.getUserName());
        pfUser.setPhoneNum(phoneNum);
        pfUser.setRegTime(new Date());
        pfUser.setRecommendUserId(recommendUserId);
        pfUser.setPicUrl(vo.getIconUrl());
        pfUser.setPushToken(vo.getPushToken());
        pfUser.setDevice(new Byte(vo.getDevice()));
        //保存用户信息
        pfUserMapper.insertSelective(pfUser);

        PfUserBalance pfUserBalance = new PfUserBalance();
        pfUserBalance.setUserId(userId);
        pfUserBalance.setLastChangeTime(regTime);
        pfUserBalance.setTotalAmount(0L);
        //保存用户账户信息
        pfUserBalanceMapper.insertSelective(pfUserBalance);

        PfUserRedbag pfUserRedbag = new PfUserRedbag();
        pfUserRedbag.setUserId(userId);
        pfUserRedbag.setLastChangeTime(regTime);
        pfUserRedbag.setTotalAmount(0L);
        pfUserRedbagMapper.insertSelective(pfUserRedbag);

        PfUserVoucher pfUserVoucher = new PfUserVoucher();
        pfUserVoucher.setUserId(userId);
        pfUserVoucher.setLastChangeTime(regTime);
        pfUserVoucher.setTotalAmount(0L);

        pfUserVoucherMapper.insertSelective(pfUserVoucher);

        return pfUser;
    }
}
