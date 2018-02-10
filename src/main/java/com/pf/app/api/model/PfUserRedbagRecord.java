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

    /**
     * 是否使用标识1：未使用2：已使用
     */
    @Column(name = "used_flag")
    private Byte usedFlag;

    /**
     * 过期时间
     */
    @Column(name = "valid_end_time")
    private Date validEndTime;

    /**
     * 0：无门槛 10：满十元可用
     */
    @Column(name = "use_condition")
    private Integer useCondition;

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

    /**
     * 获取是否使用标识1：未使用2：已使用
     *
     * @return used_flag - 是否使用标识1：未使用2：已使用
     */
    public Byte getUsedFlag() {
        return usedFlag;
    }

    /**
     * 设置是否使用标识1：未使用2：已使用
     *
     * @param usedFlag 是否使用标识1：未使用2：已使用
     */
    public void setUsedFlag(Byte usedFlag) {
        this.usedFlag = usedFlag;
    }

    /**
     * 获取过期时间
     *
     * @return valid_end_time - 过期时间
     */
    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 设置过期时间
     *
     * @param validEndTime 过期时间
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    /**
     * 获取0：无门槛 10：满十元可用
     *
     * @return use_condition - 0：无门槛 10：满十元可用
     */
    public Integer getUseCondition() {
        return useCondition;
    }

    /**
     * 设置0：无门槛 10：满十元可用
     *
     * @param useCondition 0：无门槛 10：满十元可用
     */
    public void setUseCondition(Integer useCondition) {
        this.useCondition = useCondition;
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
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGetWay() == null ? other.getGetWay() == null : this.getGetWay().equals(other.getGetWay()))
            && (this.getGetWayExplain() == null ? other.getGetWayExplain() == null : this.getGetWayExplain().equals(other.getGetWayExplain()))
            && (this.getUsedFlag() == null ? other.getUsedFlag() == null : this.getUsedFlag().equals(other.getUsedFlag()))
            && (this.getValidEndTime() == null ? other.getValidEndTime() == null : this.getValidEndTime().equals(other.getValidEndTime()))
            && (this.getUseCondition() == null ? other.getUseCondition() == null : this.getUseCondition().equals(other.getUseCondition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGetWay() == null) ? 0 : getGetWay().hashCode());
        result = prime * result + ((getGetWayExplain() == null) ? 0 : getGetWayExplain().hashCode());
        result = prime * result + ((getUsedFlag() == null) ? 0 : getUsedFlag().hashCode());
        result = prime * result + ((getValidEndTime() == null) ? 0 : getValidEndTime().hashCode());
        result = prime * result + ((getUseCondition() == null) ? 0 : getUseCondition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", getWay=").append(getWay);
        sb.append(", getWayExplain=").append(getWayExplain);
        sb.append(", usedFlag=").append(usedFlag);
        sb.append(", validEndTime=").append(validEndTime);
        sb.append(", useCondition=").append(useCondition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}