package com.pf.app.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user_balance")
public class PfUserBalance implements Serializable {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户总钱数
     */
    @Column(name = "total_amount")
    private Long totalAmount;

    /**
     * 最后一次变更时间
     */
    @Column(name = "last_change_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastChangeTime;

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
     * 获取用户总钱数
     *
     * @return total_amount - 用户总钱数
     */
    public Long getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置用户总钱数
     *
     * @param totalAmount 用户总钱数
     */
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取最后一次变更时间
     *
     * @return last_change_time - 最后一次变更时间
     */
    public Date getLastChangeTime() {
        return lastChangeTime;
    }

    /**
     * 设置最后一次变更时间
     *
     * @param lastChangeTime 最后一次变更时间
     */
    public void setLastChangeTime(Date lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
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
        PfUserBalance other = (PfUserBalance) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getLastChangeTime() == null ? other.getLastChangeTime() == null : this.getLastChangeTime().equals(other.getLastChangeTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getLastChangeTime() == null) ? 0 : getLastChangeTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", lastChangeTime=").append(lastChangeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}