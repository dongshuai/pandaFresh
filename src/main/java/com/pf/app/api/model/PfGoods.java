package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_goods")
public class PfGoods implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 商品类型主键
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 配送类型1:30分钟达2：次日达
     */
    @Column(name = "delivery_type")
    private Byte deliveryType;

    /**
     * 是否为推荐商品0：不推荐 >0 推荐，数越大排序越靠后
     */
    @Column(name = "recommend_seq")
    private Integer recommendSeq;

    /**
     * 0
     */
    @Column(name = "berserk_seq")
    private Integer berserkSeq;

    /**
     * 人工排序
     */
    @Column(name = "order_seq")
    private Integer orderSeq;

    /**
     * 是否在售
     */
    @Column(name = "sale_flag")
    private Byte saleFlag;

    /**
     * 详情页面url
     */
    @Column(name = "detail_url")
    private String detailUrl;

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
     * 获取商品类型主键
     *
     * @return category_id - 商品类型主键
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品类型主键
     *
     * @param categoryId 商品类型主键
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取配送类型1:30分钟达2：次日达
     *
     * @return delivery_type - 配送类型1:30分钟达2：次日达
     */
    public Byte getDeliveryType() {
        return deliveryType;
    }

    /**
     * 设置配送类型1:30分钟达2：次日达
     *
     * @param deliveryType 配送类型1:30分钟达2：次日达
     */
    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 获取是否为推荐商品0：不推荐 >0 推荐，数越大排序越靠后
     *
     * @return recommend_seq - 是否为推荐商品0：不推荐 >0 推荐，数越大排序越靠后
     */
    public Integer getRecommendSeq() {
        return recommendSeq;
    }

    /**
     * 设置是否为推荐商品0：不推荐 >0 推荐，数越大排序越靠后
     *
     * @param recommendSeq 是否为推荐商品0：不推荐 >0 推荐，数越大排序越靠后
     */
    public void setRecommendSeq(Integer recommendSeq) {
        this.recommendSeq = recommendSeq;
    }

    /**
     * 获取0
     *
     * @return berserk_seq - 0
     */
    public Integer getBerserkSeq() {
        return berserkSeq;
    }

    /**
     * 设置0
     *
     * @param berserkSeq 0
     */
    public void setBerserkSeq(Integer berserkSeq) {
        this.berserkSeq = berserkSeq;
    }

    /**
     * 获取人工排序
     *
     * @return order_seq - 人工排序
     */
    public Integer getOrderSeq() {
        return orderSeq;
    }

    /**
     * 设置人工排序
     *
     * @param orderSeq 人工排序
     */
    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    /**
     * 获取是否在售
     *
     * @return sale_flag - 是否在售
     */
    public Byte getSaleFlag() {
        return saleFlag;
    }

    /**
     * 设置是否在售
     *
     * @param saleFlag 是否在售
     */
    public void setSaleFlag(Byte saleFlag) {
        this.saleFlag = saleFlag;
    }

    /**
     * 获取详情页面url
     *
     * @return detail_url - 详情页面url
     */
    public String getDetailUrl() {
        return detailUrl;
    }

    /**
     * 设置详情页面url
     *
     * @param detailUrl 详情页面url
     */
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
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
        PfGoods other = (PfGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDeliveryType() == null ? other.getDeliveryType() == null : this.getDeliveryType().equals(other.getDeliveryType()))
            && (this.getRecommendSeq() == null ? other.getRecommendSeq() == null : this.getRecommendSeq().equals(other.getRecommendSeq()))
            && (this.getBerserkSeq() == null ? other.getBerserkSeq() == null : this.getBerserkSeq().equals(other.getBerserkSeq()))
            && (this.getOrderSeq() == null ? other.getOrderSeq() == null : this.getOrderSeq().equals(other.getOrderSeq()))
            && (this.getSaleFlag() == null ? other.getSaleFlag() == null : this.getSaleFlag().equals(other.getSaleFlag()))
            && (this.getDetailUrl() == null ? other.getDetailUrl() == null : this.getDetailUrl().equals(other.getDetailUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDeliveryType() == null) ? 0 : getDeliveryType().hashCode());
        result = prime * result + ((getRecommendSeq() == null) ? 0 : getRecommendSeq().hashCode());
        result = prime * result + ((getBerserkSeq() == null) ? 0 : getBerserkSeq().hashCode());
        result = prime * result + ((getOrderSeq() == null) ? 0 : getOrderSeq().hashCode());
        result = prime * result + ((getSaleFlag() == null) ? 0 : getSaleFlag().hashCode());
        result = prime * result + ((getDetailUrl() == null) ? 0 : getDetailUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", recommendSeq=").append(recommendSeq);
        sb.append(", berserkSeq=").append(berserkSeq);
        sb.append(", orderSeq=").append(orderSeq);
        sb.append(", saleFlag=").append(saleFlag);
        sb.append(", detailUrl=").append(detailUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}