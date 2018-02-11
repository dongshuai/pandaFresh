package com.pf.app.api.service;

import com.pf.app.api.mapper.PfPhoneCodeMapper;
import com.pf.app.api.mapper.PfUserBalanceMapper;
import com.pf.app.api.mapper.PfUserLoginExpMapper;
import com.pf.app.api.mapper.PfUserMapper;
import com.pf.app.api.mapper.PfUserRedbagMapper;
import com.pf.app.api.mapper.PfUserVoucherMapper;
import com.pf.app.api.model.PfPhoneCode;
import com.pf.app.api.model.PfUser;
import com.pf.app.api.model.PfUserBalance;
import com.pf.app.api.model.PfUserRedbag;
import com.pf.app.api.model.PfUserVoucher;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.util.JwtUtil;
import com.pf.app.api.util.ValidatorUtil;
import com.pf.app.api.util.VerificationExpUtil;
import com.pf.app.api.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class LoginService extends AbstractService<LoginVo> {

    @Resource
    private PfUserLoginExpMapper pfUserLoginExpMapper;
    @Resource
    private PfUserMapper pfUserMapper;
    @Resource
    private PfUserBalanceMapper pfUserBalanceMapper;
    @Resource
    private PfUserRedbagMapper pfUserRedbagMapper;
    @Resource
    private PfUserVoucherMapper pfUserVoucherMapper;
    @Resource
    private PfPhoneCodeMapper pfPhoneCodeMapper;

    @Override
    public InterfaceResponse check(LoginVo vo) {

        logger.info("用户登录参数验证开始");

        if(!ValidatorUtil.isMobile(vo.getPhoneNum())){
            return error(1000,"手机号错误");
        };
        if(StringUtils.isBlank(vo.getVerificationCode())){
            return error(1000,"验证码错误");
        }

        logger.info("用户登录参数验证结束");
        return null;
    }



    @Override
    public InterfaceResponse executor(LoginVo vo){
        logger.info("用户登录执行开始");

        String phoneNum = vo.getPhoneNum();
        PfPhoneCode pfPhoneCode = pfPhoneCodeMapper.selectByPrimaryKey(phoneNum);
        String verificationCode = vo.getVerificationCode();
        if(pfPhoneCode==null){
            logger.debug("用户验证码不正确");
            return error(1000,"验证码错误");
        }
        Date expDate = DateUtils.addMinutes(pfPhoneCode.getCreateTime(),pfPhoneCode.getExp());
        if(VerificationExpUtil.isExp(expDate)){
            logger.debug("用户验证码过期");
            return error(1000,"验证码错误");
        }
        String code = pfPhoneCode.getCode();
        if(!StringUtils.equals(code,verificationCode)){
            logger.debug("用户验证码错误");
            return error(1000,"验证码错误");
        }

        Example pfUserExample = new Example(PfUser.class);
        pfUserExample.createCriteria().andEqualTo("phoneNum",phoneNum);
        List<PfUser> pfUserList = pfUserMapper.selectByExample(pfUserExample);
        PfUser pfUser = null;
        if(pfUserList.isEmpty()){
            logger.debug("保存用户信息");
            pfUser = this.saveUserInfo(vo);
        }else {
            logger.debug("用户已经注册，获取用户信息");
            pfUser = pfUserList.get(0);
        }
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


        logger.info("用户登录执行结束");
        return success(token);
    }

    private PfUser  saveUserInfo(LoginVo vo){
        String phoneNum = vo.getPhoneNum();
        Long recommendUserId = vo.getRecommendUserId();
        Long userId = IdWorkerFactory.getIdWorker().nextId();
        Date regTime = new Date();
        PfUser pfUser = new PfUser();
        pfUser.setId(userId);
        pfUser.setNickname(phoneNum);
        pfUser.setPhoneNum(phoneNum);
        pfUser.setRegTime(new Date());
        pfUser.setRecommendUserId(recommendUserId);
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
