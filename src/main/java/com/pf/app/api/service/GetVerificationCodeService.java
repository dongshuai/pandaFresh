package com.pf.app.api.service;

import com.pf.app.api.mapper.PfPhoneCodeMapper;
import com.pf.app.api.model.PfPhoneCode;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.RandomNumUtil;
import com.pf.app.api.util.ValidatorUtil;
import com.pf.app.api.vo.VerificationCodeVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class GetVerificationCodeService extends AbstractService<VerificationCodeVo> {

    private static final Logger logger = LoggerFactory.getLogger(GetVerificationCodeService.class);

    @Resource
    private PfPhoneCodeMapper pfPhoneCodeMapper;
    @Override
    public InterfaceResponse check(VerificationCodeVo vo) {
        logger.info("验证参数开始");
        logger.debug("传入参数：{}",vo);
        String phoneNum = vo.getPhoneNum();
        if(!ValidatorUtil.isMobile(phoneNum)){
           return error(1000,"手机号码错误");
        }
        logger.info("验证参数结束");
        return null;
    }

    @Override
    public InterfaceResponse executor(VerificationCodeVo vo) {
        logger.info("发送验证码开始");
        String phoneNum = vo.getPhoneNum();

        PfPhoneCode ppc = pfPhoneCodeMapper.selectByPrimaryKey(phoneNum);

        String code = null;
        if(null == ppc){
            logger.debug("首次发送短信验证");
            PfPhoneCode pfPhoneCode = new PfPhoneCode();
            code = RandomNumUtil.get6RandNum();
            pfPhoneCode.setCode(code);
            pfPhoneCode.setPhoneNum(phoneNum);
            pfPhoneCodeMapper.insertSelective(pfPhoneCode);
        }else{
            code = ppc.getCode();
            logger.debug("有发送历史");
            int exp = ppc.getExp();
            Date createTime = ppc.getCreateTime();
            Date expTime = DateUtils.addMinutes(createTime,exp);
            Date now = new Date();

            if(now.getTime()>=expTime.getTime()){
                logger.debug("验证码已过期");
                PfPhoneCode pfPhoneCode = new PfPhoneCode();
                code = RandomNumUtil.get6RandNum();
                pfPhoneCode.setCode(code);
                pfPhoneCode.setPhoneNum(phoneNum);
                pfPhoneCode.setCreateTime(now);
                pfPhoneCodeMapper.updateByPrimaryKeySelective(pfPhoneCode);
            }else{
                logger.debug("验证码未过期");
            }
        }
        //调用阿里大鱼短信接口
        logger.debug("手机验证码：{}",code);
        logger.info("发送验证码结束");

        return success();
    }


}
