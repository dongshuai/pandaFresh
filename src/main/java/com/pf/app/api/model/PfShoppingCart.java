package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_shopping_cart")
public class PfShoppingCart implements Serializable {
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
     * 商品主键
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer amount;

    /**
     * 配送单主键 0：表示未付款
     */
    @Column(name = "delivery_id")
    private Long deliveryId;

    /**
     * 配送类型1:30分钟达2：次日达
     */
    @Column(name = "delivery_type")
    private Byte deliveryType;

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
     * 获取商品主键
     *
     * @return goods_id - 商品主键
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品主键
     *
     * @param goodsId 商品主键
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取商品数量
     *
     * @return amount - 商品数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置商品数量
     *
     * @param amount 商品数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取配送单主键 0：表示未付款
     *
     * @return delivery_id - 配送单主键 0：表示未付款
     */
    public Long getDeliveryId() {
        return deliveryId;
    }

    /**
     * 设置配送单主键 0：表示未付款
     *
     * @param deliveryId 配送单主键 0：表示未付款
     */
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * 获取配送单类型:30分钟达2：次日达
     *
     * @return deliveryType - 配送单主键 0：表示未付款
     */

    public Byte getDeliveryType() {
        return deliveryType;
    }
    /**
     * 设置配送单类型:30分钟达2：次日达
     *
     * @param deliveryType 配送单主键 0：表示未付款
     */
    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
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
        PfShoppingCart other = (PfShoppingCart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDeliveryId() == null ? other.getDeliveryId() == null : this.getDeliveryId().equals(other.getDeliveryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDeliveryId() == null) ? 0 : getDeliveryId().hashCode());
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", amount=").append(amount);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}