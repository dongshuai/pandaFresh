package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user_detail")
public class PfUserDetail implements Serializable {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户支付密码
     */
    @Column(name = "pay_pwd")
    private String payPwd;

    /**
     * 用户会员结束日期
     */
    @Column(name = "member_end_date")
    private Date memberEndDate;

    private static final long serialVersionUID = 1L;

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

    /**
     * 获取用户支付密码
     *
     * @return pay_pwd - 用户支付密码
     */
    public String getPayPwd() {
        return payPwd;
    }

    /**
     * 设置用户支付密码
     *
     * @param payPwd 用户支付密码
     */
    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    /**
     * 获取用户会员结束日期
     *
     * @return member_end_date - 用户会员结束日期
     */
    public Date getMemberEndDate() {
        return memberEndDate;
    }

    /**
     * 设置用户会员结束日期
     *
     * @param memberEndDate 用户会员结束日期
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
        PfUserDetail other = (PfUserDetail) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPayPwd() == null ? other.getPayPwd() == null : this.getPayPwd().equals(other.getPayPwd()))
            && (this.getMemberEndDate() == null ? other.getMemberEndDate() == null : this.getMemberEndDate().equals(other.getMemberEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPayPwd() == null) ? 0 : getPayPwd().hashCode());
        result = prime * result + ((getMemberEndDate() == null) ? 0 : getMemberEndDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", payPwd=").append(payPwd);
        sb.append(", memberEndDate=").append(memberEndDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}