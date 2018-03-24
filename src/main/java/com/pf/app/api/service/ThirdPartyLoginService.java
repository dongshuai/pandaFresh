package com.pf.app.api.service;


import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfThirdPartyLoginInfoMapper;
import com.pf.app.api.mapper.PfUserBalanceMapper;
import com.pf.app.api.mapper.PfUserMapper;
import com.pf.app.api.mapper.PfUserRedbagMapper;
import com.pf.app.api.mapper.PfUserVoucherMapper;
import com.pf.app.api.model.PfThirdPartyLoginInfo;
import com.pf.app.api.model.PfUser;
import com.pf.app.api.model.PfUserBalance;
import com.pf.app.api.model.PfUserRedbag;
import com.pf.app.api.model.PfUserVoucher;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.util.JwtUtil;
import com.pf.app.api.vo.ThirdPartyLoginVo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

;

@Service
@ReadOnly
public class ThirdPartyLoginService extends AbstractService<ThirdPartyLoginVo> {


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
	public InterfaceResponse check(ThirdPartyLoginVo t) {
		if("0".equals(t.getType()+"")){//微信
			if (null == t.getUnionid() || "".equals(t.getUnionid())) {
				return error(3001,"参数Unionid不能为空");
			}
			if(null== t.getOpenid() || "".equals(t.getOpenid())){
				return error(3002,"参数Openid不能为空");
			}
		}else if("1".equals(t.getType()+"")){//QQ
			if(null== t.getUid() || "".equals(t.getUid())){
				return error(3003,"参数Uid不能为空");
			}
			if(null== t.getOpenid() || "".equals(t.getOpenid())){
				return error(3004,"参数Openid不能为空");
			}
		}else if("2".equals(t.getType()+"")){//微博
			if(null== t.getUid() || "".equals(t.getUid())){
				return error(3005,"参数Uid不能为空");
			}
		}else{
			logger.error("第三方登录otherType错误：UserOtherVo={}",t.toString());
			return error(3006,"第三方用户类型错误");
		}
		return null;
	}

	@Override
	public InterfaceResponse executor(ThirdPartyLoginVo t) {
		logger.info("UserOtherService第三方登录传参={}",t.toString());
		Example exm = new Example(PfThirdPartyLoginInfo.class);
		Example.Criteria cri = exm.createCriteria();
		cri.andEqualTo("type",t.getType());
		if ("0".equals(t.getType() + "")) {
			logger.debug("微信登录");
			//weixin
			cri.andEqualTo("unionid",t.getUnionid())
					.andEqualTo("openid",t.getOpenid());
		} else if ("1".equals(t.getType() + "")) {
			logger.debug("qq登录");
			//qq
			cri.andEqualTo("uid",t.getUid())
					.andEqualTo("openid",t.getOpenid());
		} else if ("2".equals(t.getType() + "")) {
			logger.debug("微博登录");
			//weibo
			cri.andEqualTo("uid",t.getUid());
		}

		List<PfThirdPartyLoginInfo> list = pfThirdPartyLoginInfoMapper.selectByExample(exm);
		if(null != list && list.size()>0){
			logger.debug("绑定过");
			PfThirdPartyLoginInfo other = list.get(0);

			PfUser pfUser = pfUserMapper.selectByPrimaryKey(other.getUserId());
			if(null != pfUser){//登录
				logger.debug("第三方登录，已经绑定了用户,并且查找到信息");

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
			}else{
				logger.error("第三方登录，已经绑定了用户userId，但是根据userId未查询到用户,参数="+t.toString()+";userId="+other.getUserId());

				return this.error(3008,"请重新绑定");
			}
		}else {
			logger.debug("用户未绑定");
			return this.error(3008,"请重新绑定");
		}
	}

}
