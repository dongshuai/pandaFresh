package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_delivery")
public class PfDelivery implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

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
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAmout() == null ? other.getAmout() == null : this.getAmout().equals(other.getAmout()))
            && (this.getDeliveryPersonId() == null ? other.getDeliveryPersonId() == null : this.getDeliveryPersonId().equals(other.getDeliveryPersonId()))
            && (this.getDeliveryCompany() == null ? other.getDeliveryCompany() == null : this.getDeliveryCompany().equals(other.getDeliveryCompany()))
            && (this.getDeliveryNum() == null ? other.getDeliveryNum() == null : this.getDeliveryNum().equals(other.getDeliveryNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAmout() == null) ? 0 : getAmout().hashCode());
        result = prime * result + ((getDeliveryPersonId() == null) ? 0 : getDeliveryPersonId().hashCode());
        result = prime * result + ((getDeliveryCompany() == null) ? 0 : getDeliveryCompany().hashCode());
        result = prime * result + ((getDeliveryNum() == null) ? 0 : getDeliveryNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", amout=").append(amout);
        sb.append(", deliveryPersonId=").append(deliveryPersonId);
        sb.append(", deliveryCompany=").append(deliveryCompany);
        sb.append(", deliveryNum=").append(deliveryNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}