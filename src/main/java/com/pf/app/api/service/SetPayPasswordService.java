package com.pf.app.api.service;

import com.pf.app.api.exception.OrderException;
import com.pf.app.api.mapper.PfPhoneCodeMapper;
import com.pf.app.api.mapper.PfUserDetailMapper;
import com.pf.app.api.mapper.PfUserMapper;
import com.pf.app.api.model.PfPhoneCode;
import com.pf.app.api.model.PfUser;
import com.pf.app.api.model.PfUserDetail;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.ValidatorUtil;
import com.pf.app.api.vo.SetPayCodeVo;
import com.sun.corba.se.spi.oa.OADestroyed;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * 设置用户支付密码
 */

@Service
public class SetPayPasswordService extends AbstractService<SetPayCodeVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(SetPayPasswordService.class);

    /**
     * 手机验证码mapper
     */
    @Autowired
    private PfPhoneCodeMapper pfPhoneCodeMapper;
    @Autowired
    private PfUserDetailMapper userDetailMapper;
    @Autowired
    private PfUserMapper pfUserMapper;


    @Override
    public InterfaceResponse check(SetPayCodeVo vo) {

        logger.info("设置用户支付密码检查参数开始");
        logger.debug("用户输入参数 [{}]",vo);





        String phoneNum = vo.getPhoneNum();
        String phoneCode =  vo.getPhoneCode();

        String password = vo.getPassword();
        String password1 = vo.getPassword1();

        if(StringUtils.isBlank(phoneNum)){
            return error(8500,"电话号码为空");
        }
        if(!ValidatorUtil.isMobile(phoneNum)){
            return error(8501,"电话号码错误");
        }
        if(StringUtils.isBlank(phoneCode)){
            return error(8502,"验证码为空");
        }

        if(StringUtils.isBlank(password)){
            return error(8503,"两次密码输入不一致");
        }
        if(StringUtils.isBlank(password1)){
            return error(8503,"两次密码输入不一致");
        }

        if(Pattern.matches("^[0-9]{6}$",password)){
            return error(8504,"请输入6位数字");
        }


        if(!password.equals(password1)){
            return error(8503,"两次密码输入不一致");
        }
        logger.info("设置用户支付密码检查参数结束");
        return null;
    }

    @Override
    public InterfaceResponse executor(SetPayCodeVo vo) {

        logger.info("用户设置密码执行开始");

        Long userId = getUserId();
        String phoneNum = vo.getPhoneNum();
        PfUser pfUser = pfUserMapper.selectByPrimaryKey(userId);
        String userPhoneNum = pfUser.getPhoneNum();
        if( !userPhoneNum.equals(phoneNum)){
            logger.debug("用户手机号码不正确，用户手机号码，传入手机号【{}】",userPhoneNum,phoneNum);
            throw new OrderException("没有此手机号对此手机号发送验证码");
        }


        PfPhoneCode ppc = pfPhoneCodeMapper.selectByPrimaryKey(phoneNum);

        if(null == ppc){
            logger.debug("没有此手机号对此手机号发送验证码，手机号【{}】",phoneNum);
            throw new OrderException("没有此手机号对此手机号发送验证码");
        }

        String code = ppc.getCode();
        if(StringUtils.isBlank(code)){
            logger.debug("验证码为空，PfPhoneCode = [{}]",ppc);
            throw new OrderException("请重新获取验证码");
        }
        Date expTime = DateUtils.addMinutes(ppc.getCreateTime(),ppc.getExp());
        Date now = new Date();

        if(now.getTime()>=expTime.getTime()){
            logger.debug("验证码过期");
            throw new OrderException("验证码过期 ,请重新获取验证码");
        }

        if(!code.equals(vo.getPhoneCode())){
            logger.debug("验证码不正确");
            throw new OrderException("验证码不正确 ,请重新获取验证码");
        }

        PfUserDetail pfUserDetail = new PfUserDetail();
        pfUserDetail.setUserId(userId);
        pfUserDetail.setPayPwd(vo.getPassword());
        PfUserDetail detail = userDetailMapper.selectByPrimaryKey(userId);
        if(detail == null ){
            pfUserDetail.setCanCash(false);
            userDetailMapper.insert(pfUserDetail);
        }else {
            userDetailMapper.updateByPrimaryKey(pfUserDetail);
        }

        return success();
    }
}
