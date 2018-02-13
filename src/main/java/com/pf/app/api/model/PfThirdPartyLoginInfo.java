package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_third_party_login_info")
public class PfThirdPartyLoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @Id
    private Long id;
    /**
     * 用户ID，微博和QQ有值
     */
    private String uid;
    /**
     * 微信和QQ有值
     */
    private String openid;
    /**
     * 用户ID、微信有值
     */
    private String unionid;
    /**
     * 微博有值，微信和QQ无值
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 微信、QQ、微博均有
     */
    @Column(name = "access_token")
    private String accessToken;
    /**
     * 微信、微博有值、QQ无值
     */
    @Column(name = "refresh_token")
    private String refreshToken;
    /**
     * 过期时间，均有
     */
    @Column(name = "expires_in")
    private String expiresIn;
    /**
     * 头像URL，微博有值
     */
    @Column(name = "icon_url")
    private String iconUrl;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 第三方平台类型；0微信、1QQ、2微博
     */
    private Byte type;
    /**
     * 用户主键
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID，微博和QQ有值
     *
     * @return uid - 用户ID，微博和QQ有值
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置用户ID，微博和QQ有值
     *
     * @param uid 用户ID，微博和QQ有值
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * 获取微信和QQ有值
     *
     * @return openid - 微信和QQ有值
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信和QQ有值
     *
     * @param openid 微信和QQ有值
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取用户ID、微信有值
     *
     * @return unionid - 用户ID、微信有值
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置用户ID、微信有值
     *
     * @param unionid 用户ID、微信有值
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * 获取微博有值，微信和QQ无值
     *
     * @return user_name - 微博有值，微信和QQ无值
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置微博有值，微信和QQ无值
     *
     * @param userName 微博有值，微信和QQ无值
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取微信、QQ、微博均有
     *
     * @return access_token - 微信、QQ、微博均有
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置微信、QQ、微博均有
     *
     * @param accessToken 微信、QQ、微博均有
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    /**
     * 获取微信、微博有值、QQ无值
     *
     * @return refresh_token - 微信、微博有值、QQ无值
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 设置微信、微博有值、QQ无值
     *
     * @param refreshToken 微信、微博有值、QQ无值
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    /**
     * 获取过期时间，均有
     *
     * @return expires_in - 过期时间，均有
     */
    public String getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置过期时间，均有
     *
     * @param expiresIn 过期时间，均有
     */
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn == null ? null : expiresIn.trim();
    }

    /**
     * 获取头像URL，微博有值
     *
     * @return icon_url - 头像URL，微博有值
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置头像URL，微博有值
     *
     * @param iconUrl 头像URL，微博有值
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取第三方平台类型；0微信、1QQ、2微博
     *
     * @return type - 第三方平台类型；0微信、1QQ、2微博
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置第三方平台类型；0微信、1QQ、2微博
     *
     * @param type 第三方平台类型；0微信、1QQ、2微博
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取用户主键
     *
     * @return user_id - 用户主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户主键
     *
     * @param userId 用户主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PfThirdPartyLoginInfo other = (PfThirdPartyLoginInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getUnionid() == null ? other.getUnionid() == null : this.getUnionid().equals(other.getUnionid()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getAccessToken() == null ? other.getAccessToken() == null : this.getAccessToken().equals(other.getAccessToken()))
            && (this.getRefreshToken() == null ? other.getRefreshToken() == null : this.getRefreshToken().equals(other.getRefreshToken()))
            && (this.getExpiresIn() == null ? other.getExpiresIn() == null : this.getExpiresIn().equals(other.getExpiresIn()))
            && (this.getIconUrl() == null ? other.getIconUrl() == null : this.getIconUrl().equals(other.getIconUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getUnionid() == null) ? 0 : getUnionid().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getAccessToken() == null) ? 0 : getAccessToken().hashCode());
        result = prime * result + ((getRefreshToken() == null) ? 0 : getRefreshToken().hashCode());
        result = prime * result + ((getExpiresIn() == null) ? 0 : getExpiresIn().hashCode());
        result = prime * result + ((getIconUrl() == null) ? 0 : getIconUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", openid=").append(openid);
        sb.append(", unionid=").append(unionid);
        sb.append(", userName=").append(userName);
        sb.append(", accessToken=").append(accessToken);
        sb.append(", refreshToken=").append(refreshToken);
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", iconUrl=").append(iconUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}