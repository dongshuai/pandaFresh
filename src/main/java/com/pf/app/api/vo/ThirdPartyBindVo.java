package com.pf.app.api.vo;

import java.util.Date;

public class ThirdPartyBindVo implements VO {

	private String phoneNum;
	private String verificationCode;
	private Long recommendUserId;


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

	@Override
	public String toString() {
		return "UserOtherVo [uid=" + uid + ", openid=" + openid + ", unionid=" + unionid
				+ ", userName=" + userName + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken
				+ ", expiresIn=" + expiresIn + ", iconUrl=" + iconUrl + ", createTime=" + createTime + ", type="
				+ type +  "]";
	}

    
    
}
