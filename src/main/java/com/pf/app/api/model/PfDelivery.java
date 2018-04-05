package com.pf.app.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_delivery")
public class PfDelivery implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 收货人id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单类型1:及时达，2：次日达
     */
    private Byte type;

    /**
     * 配送单价格
     */
    private Long amout;

    /**
     * 配送人主键 0：公司
     */
    @Column(name = "delivery_person_id")
    private Long deliveryPersonId;

    /**
     * 配送公司名称
     */
    @Column(name = "delivery_company")
    private String deliveryCompany;

    /**
     * 配送单号
     */
    @Column(name = "delivery_num")
    private String deliveryNum;

    /**
     * 送达时间
     */
    @Column(name = "arrive_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arriveTime;

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
     * 获取收货人id
     *
     * @return user_id - 收货人id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置收货人id
     *
     * @param userId 收货人id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单类型1:及时达，2：次日达
     *
     * @return type - 订单类型1:及时达，2：次日达
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置订单类型1:及时达，2：次日达
     *
     * @param type 订单类型1:及时达，2：次日达
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取配送单价格
     *
     * @return amout - 配送单价格
     */
    public Long getAmout() {
        return amout;
    }

    /**
     * 设置配送单价格
     *
     * @param amout 配送单价格
     */
    public void setAmout(Long amout) {
        this.amout = amout;
    }

    /**
     * 获取配送人主键 0：公司
     *
     * @return delivery_person_id - 配送人主键 0：公司
     */
    public Long getDeliveryPersonId() {
        return deliveryPersonId;
    }

    /**
     * 设置配送人主键 0：公司
     *
     * @param deliveryPersonId 配送人主键 0：公司
     */
    public void setDeliveryPersonId(Long deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    /**
     * 获取配送公司名称
     *
     * @return delivery_company - 配送公司名称
     */
    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    /**
     * 设置配送公司名称
     *
     * @param deliveryCompany 配送公司名称
     */
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany == null ? null : deliveryCompany.trim();
    }

    /**
     * 获取配送单号
     *
     * @return delivery_num - 配送单号
     */
    public String getDeliveryNum() {
        return deliveryNum;
    }

    /**
     * 设置配送单号
     *
     * @param deliveryNum 配送单号
     */
    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum == null ? null : deliveryNum.trim();
    }

    /**
     * 获取送达时间
     *
     * @return arrive_time - 送达时间
     */
    public Date getArriveTime() {
        return arriveTime;
    }

    /**
     * 设置送达时间
     *
     * @param arriveTime 送达时间
     */
    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
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
        PfDelivery other = (PfDelivery) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAmout() == null ? other.getAmout() == null : this.getAmout().equals(other.getAmout()))
            && (this.getDeliveryPersonId() == null ? other.getDeliveryPersonId() == null : this.getDeliveryPersonId().equals(other.getDeliveryPersonId()))
            && (this.getDeliveryCompany() == null ? other.getDeliveryCompany() == null : this.getDeliveryCompany().equals(other.getDeliveryCompany()))
            && (this.getDeliveryNum() == null ? other.getDeliveryNum() == null : this.getDeliveryNum().equals(other.getDeliveryNum()))
            && (this.getArriveTime() == null ? other.getArriveTime() == null : this.getArriveTime().equals(other.getArriveTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAmout() == null) ? 0 : getAmout().hashCode());
        result = prime * result + ((getDeliveryPersonId() == null) ? 0 : getDeliveryPersonId().hashCode());
        result = prime * result + ((getDeliveryCompany() == null) ? 0 : getDeliveryCompany().hashCode());
        result = prime * result + ((getDeliveryNum() == null) ? 0 : getDeliveryNum().hashCode());
        result = prime * result + ((getArriveTime() == null) ? 0 : getArriveTime().hashCode());
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
        sb.append(", orderId=").append(orderId);
        sb.append(", type=").append(type);
        sb.append(", amout=").append(amout);
        sb.append(", deliveryPersonId=").append(deliveryPersonId);
        sb.append(", deliveryCompany=").append(deliveryCompany);
        sb.append(", deliveryNum=").append(deliveryNum);
        sb.append(", arriveTime=").append(arriveTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}