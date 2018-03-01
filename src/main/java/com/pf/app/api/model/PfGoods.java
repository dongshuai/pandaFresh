package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_goods")
public class PfGoods implements Serializable {
    /**
     * 商品数量
     */
    @Transient
    Integer amout;

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
     * 商品类型1:正常商品2：预售商品3：折扣商品
     */
    private Byte type;

    /**
     * 配送类型1:30分钟达2：次日达
     */
    @Column(name = "delivery_type")
    private Byte deliveryType;

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

    /**
     * 城市名称
     */
    private String city;

    /**
     * 商品原价，单位：分
     */
    private Long price;

    /**
     * 商品价格类型（1：正常价格2：会员价格3：折扣价格4：第二件半价）
     */
    @Column(name = "price_type")
    private Byte priceType;

    /**
     * 会员价格 单位：分（正常价格 会员价格 折扣价格 第二件半价）
     */
    @Column(name = "real_price")
    private Long realPrice;

    /**
     * 推荐排序,0:不推荐 >0 推荐数字越小越靠前
     */
    @Column(name = "recommend_seq")
    private Integer recommendSeq;

    /**
     * 爆款推荐，0：不推荐 >0推荐
     */
    @Column(name = "berserk_seq")
    private Integer berserkSeq;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }

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
     * 获取商品类型1:正常商品2：预售商品3：折扣商品
     *
     * @return type - 商品类型1:正常商品2：预售商品3：折扣商品
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置商品类型1:正常商品2：预售商品3：折扣商品
     *
     * @param type 商品类型1:正常商品2：预售商品3：折扣商品
     */
    public void setType(Byte type) {
        this.type = type;
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

    /**
     * 获取城市名称
     *
     * @return city - 城市名称
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市名称
     *
     * @param city 城市名称
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取商品原价，单位：分
     *
     * @return price - 商品原价，单位：分
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置商品原价，单位：分
     *
     * @param price 商品原价，单位：分
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取商品价格类型（1：正常价格2：会员价格3：折扣价格4：第二件半价）
     *
     * @return price_type - 商品价格类型（1：正常价格2：会员价格3：折扣价格4：第二件半价）
     */
    public Byte getPriceType() {
        return priceType;
    }

    /**
     * 设置商品价格类型（1：正常价格2：会员价格3：折扣价格4：第二件半价）
     *
     * @param priceType 商品价格类型（1：正常价格2：会员价格3：折扣价格4：第二件半价）
     */
    public void setPriceType(Byte priceType) {
        this.priceType = priceType;
    }

    /**
     * 获取会员价格 单位：分（正常价格 会员价格 折扣价格 第二件半价）
     *
     * @return real_price - 会员价格 单位：分（正常价格 会员价格 折扣价格 第二件半价）
     */
    public Long getRealPrice() {
        return realPrice;
    }

    /**
     * 设置会员价格 单位：分（正常价格 会员价格 折扣价格 第二件半价）
     *
     * @param realPrice 会员价格 单位：分（正常价格 会员价格 折扣价格 第二件半价）
     */
    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    /**
     * 获取推荐排序,0:不推荐 >0 推荐数字越小越靠前
     *
     * @return recommend_seq - 推荐排序,0:不推荐 >0 推荐数字越小越靠前
     */
    public Integer getRecommendSeq() {
        return recommendSeq;
    }

    /**
     * 设置推荐排序,0:不推荐 >0 推荐数字越小越靠前
     *
     * @param recommendSeq 推荐排序,0:不推荐 >0 推荐数字越小越靠前
     */
    public void setRecommendSeq(Integer recommendSeq) {
        this.recommendSeq = recommendSeq;
    }

    /**
     * 获取爆款推荐，0：不推荐 >0推荐
     *
     * @return berserk_seq - 爆款推荐，0：不推荐 >0推荐
     */
    public Integer getBerserkSeq() {
        return berserkSeq;
    }

    /**
     * 设置爆款推荐，0：不推荐 >0推荐
     *
     * @param berserkSeq 爆款推荐，0：不推荐 >0推荐
     */
    public void setBerserkSeq(Integer berserkSeq) {
        this.berserkSeq = berserkSeq;
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
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDeliveryType() == null ? other.getDeliveryType() == null : this.getDeliveryType().equals(other.getDeliveryType()))
            && (this.getOrderSeq() == null ? other.getOrderSeq() == null : this.getOrderSeq().equals(other.getOrderSeq()))
            && (this.getSaleFlag() == null ? other.getSaleFlag() == null : this.getSaleFlag().equals(other.getSaleFlag()))
            && (this.getDetailUrl() == null ? other.getDetailUrl() == null : this.getDetailUrl().equals(other.getDetailUrl()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPriceType() == null ? other.getPriceType() == null : this.getPriceType().equals(other.getPriceType()))
            && (this.getRealPrice() == null ? other.getRealPrice() == null : this.getRealPrice().equals(other.getRealPrice()))
            && (this.getRecommendSeq() == null ? other.getRecommendSeq() == null : this.getRecommendSeq().equals(other.getRecommendSeq()))
            && (this.getBerserkSeq() == null ? other.getBerserkSeq() == null : this.getBerserkSeq().equals(other.getBerserkSeq()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDeliveryType() == null) ? 0 : getDeliveryType().hashCode());
        result = prime * result + ((getOrderSeq() == null) ? 0 : getOrderSeq().hashCode());
        result = prime * result + ((getSaleFlag() == null) ? 0 : getSaleFlag().hashCode());
        result = prime * result + ((getDetailUrl() == null) ? 0 : getDetailUrl().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPriceType() == null) ? 0 : getPriceType().hashCode());
        result = prime * result + ((getRealPrice() == null) ? 0 : getRealPrice().hashCode());
        result = prime * result + ((getRecommendSeq() == null) ? 0 : getRecommendSeq().hashCode());
        result = prime * result + ((getBerserkSeq() == null) ? 0 : getBerserkSeq().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append(", orderSeq=").append(orderSeq);
        sb.append(", saleFlag=").append(saleFlag);
        sb.append(", detailUrl=").append(detailUrl);
        sb.append(", city=").append(city);
        sb.append(", price=").append(price);
        sb.append(", priceType=").append(priceType);
        sb.append(", realPrice=").append(realPrice);
        sb.append(", recommendSeq=").append(recommendSeq);
        sb.append(", berserkSeq=").append(berserkSeq);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}