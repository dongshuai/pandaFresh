package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user_redbag_record")
public class PfUserRedbagRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户主键
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 面值大小
     */
    private Long amount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取途径1：兑换2：好友消费3：用户提现
     */
    @Column(name = "get_way")
    private String getWay;

    /**
     * 获取说明
     */
    @Column(name = "get_way_explain")
    private String getWayExplain;

    private static final long serialVersionUID = 1L;

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
     * 获取面值大小
     *
     * @return amount - 面值大小
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置面值大小
     *
     * @param amount 面值大小
     */
    public void setAmount(Long amount) {
        this.amount = amount;
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
     * 获取获取途径1：兑换2：好友消费3：用户提现
     *
     * @return get_way - 获取途径1：兑换2：好友消费3：用户提现
     */
    public String getGetWay() {
        return getWay;
    }

    /**
     * 设置获取途径1：兑换2：好友消费3：用户提现
     *
     * @param getWay 获取途径1：兑换2：好友消费3：用户提现
     */
    public void setGetWay(String getWay) {
        this.getWay = getWay == null ? null : getWay.trim();
    }

    /**
     * 获取获取说明
     *
     * @return get_way_explain - 获取说明
     */
    public String getGetWayExplain() {
        return getWayExplain;
    }

    /**
     * 设置获取说明
     *
     * @param getWayExplain 获取说明
     */
    public void setGetWayExplain(String getWayExplain) {
        this.getWayExplain = getWayExplain == null ? null : getWayExplain.trim();
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
        PfUserRedbagRecord other = (PfUserRedbagRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGetWay() == null ? other.getGetWay() == null : this.getGetWay().equals(other.getGetWay()))
            && (this.getGetWayExplain() == null ? other.getGetWayExplain() == null : this.getGetWayExplain().equals(other.getGetWayExplain()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGetWay() == null) ? 0 : getGetWay().hashCode());
        result = prime * result + ((getGetWayExplain() == null) ? 0 : getGetWayExplain().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", getWay=").append(getWay);
        sb.append(", getWayExplain=").append(getWayExplain);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}