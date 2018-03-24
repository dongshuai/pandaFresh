package com.pf.app.api.vo;

import java.util.Date;

public class ThirdPartyBindVo implements VO {

	private String phoneNum;
	private String verificationCode;
	private Long recommendUserId;
	private String pushToken;
	private String device;


    /** 用户ID，微博和QQ有值 */
    private String uid;
    /** 微信和QQ有值 */
    private String openid;
    /** 用户ID、微信有值 */
    private String unionid;
    /** 微博有值，微信和QQ无值 */
    private String userName;
    /** 微信、QQ、微博均有 */
    private String accessToken;
    /** 微信、微博有值、QQ无值 */
    private String refreshToken;
    /** 过期时间，均有 */
    private String expiresIn;
    /** 头像URL，微博有值 */
    private String iconUrl;
    /** 创建时间 */
    private Date createTime;
    /** 0微信、1QQ、2微博 */
    private Integer type;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Long getRecommendUserId() {
		return recommendUserId;
	}

	public void setRecommendUserId(Long recommendUserId) {
		this.recommendUserId = recommendUserId;
	}


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	//授权过查询用户信息


	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ThirdPartyBindVo{");
		sb.append("phoneNum='").append(phoneNum).append('\'');
		sb.append(", verificationCode='").append(verificationCode).append('\'');
		sb.append(", recommendUserId=").append(recommendUserId);
		sb.append(", pushToken='").append(pushToken).append('\'');
		sb.append(", device='").append(device).append('\'');
		sb.append(", uid='").append(uid).append('\'');
		sb.append(", openid='").append(openid).append('\'');
		sb.append(", unionid='").append(unionid).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", accessToken='").append(accessToken).append('\'');
		sb.append(", refreshToken='").append(refreshToken).append('\'');
		sb.append(", expiresIn='").append(expiresIn).append('\'');
		sb.append(", iconUrl='").append(iconUrl).append('\'');
		sb.append(", createTime=").append(createTime);
		sb.append(", type=").append(type);
		sb.append('}');
		return sb.toString();
	}
}
