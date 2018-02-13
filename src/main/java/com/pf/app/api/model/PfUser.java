package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user")
public class PfUser implements Serializable {
    /**
     * 是否是会员 true 是 false 否
     */
    @Transient
    Boolean member;
    /**
     * 用户主键
     */
    @Id
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像url
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 手机号
     */
    @Column(name = "phone_num")
    private String phoneNum;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 推荐人id
     */
    @Column(name = "recommend_user_id")
    private Long recommendUserId;

    /**
     * 会员到期日期
     */
    @Column(name = "member_end_date")
    private Date memberEndDate;

    private static final long serialVersionUID = 1L;

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    /**
     * 获取用户主键
     *
     * @return id - 用户主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户主键
     *
     * @param id 用户主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取头像url
     *
     * @return pic_url - 头像url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置头像url
     *
     * @param picUrl 头像url
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_num - 手机号
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机号
     *
     * @param phoneNum 手机号
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 获取注册时间
     *
     * @return reg_time - 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间
     *
     * @param regTime 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取推荐人id
     *
     * @return recommend_user_id - 推荐人id
     */
    public Long getRecommendUserId() {
        return recommendUserId;
    }

    /**
     * 设置推荐人id
     *
     * @param recommendUserId 推荐人id
     */
    public void setRecommendUserId(Long recommendUserId) {
        this.recommendUserId = recommendUserId;
    }

    /**
     * 获取会员到期日期
     *
     * @return member_end_date - 会员到期日期
     */
    public Date getMemberEndDate() {
        return memberEndDate;
    }

    /**
     * 设置会员到期日期
     *
     * @param memberEndDate 会员到期日期
     */
    public void setMemberEndDate(Date memberEndDate) {
        this.memberEndDate = memberEndDate;
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
        PfUser other = (PfUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getRecommendUserId() == null ? other.getRecommendUserId() == null : this.getRecommendUserId().equals(other.getRecommendUserId()))
            && (this.getMemberEndDate() == null ? other.getMemberEndDate() == null : this.getMemberEndDate().equals(other.getMemberEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getRecommendUserId() == null) ? 0 : getRecommendUserId().hashCode());
        result = prime * result + ((getMemberEndDate() == null) ? 0 : getMemberEndDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", regTime=").append(regTime);
        sb.append(", recommendUserId=").append(recommendUserId);
        sb.append(", memberEndDate=").append(memberEndDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}