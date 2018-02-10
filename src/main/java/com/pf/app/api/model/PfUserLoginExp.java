package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user_login_exp")
public class PfUserLoginExp implements Serializable {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 过期时间
     */
    private Date exp;

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
     * 获取过期时间
     *
     * @return exp - 过期时间
     */
    public Date getExp() {
        return exp;
    }

    /**
     * 设置过期时间
     *
     * @param exp 过期时间
     */
    public void setExp(Date exp) {
        this.exp = exp;
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
        PfUserLoginExp other = (PfUserLoginExp) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getExp() == null ? other.getExp() == null : this.getExp().equals(other.getExp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getExp() == null) ? 0 : getExp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", exp=").append(exp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}