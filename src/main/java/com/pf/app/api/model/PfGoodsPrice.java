package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_goods_price")
public class PfGoodsPrice implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 商品主键
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 商品原价，单位：分
     */
    private Long price;

    /**
     * 会员价格 单位：分
     */
    @Column(name = "member_price")
    private Long memberPrice;

    /**
     * 第二件减 单位分
     */
    @Column(name = "second_reduce")
    private Long secondReduce;

    /**
     * 推荐排序,0:不推荐 >0 推荐数字越小越靠前
     */
    @Column(name = "recommend_seq")
    private Integer recommendSeq;

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
     * 获取会员价格 单位：分
     *
     * @return member_price - 会员价格 单位：分
     */
    public Long getMemberPrice() {
        return memberPrice;
    }

    /**
     * 设置会员价格 单位：分
     *
     * @param memberPrice 会员价格 单位：分
     */
    public void setMemberPrice(Long memberPrice) {
        this.memberPrice = memberPrice;
    }

    /**
     * 获取第二件减 单位分
     *
     * @return second_reduce - 第二件减 单位分
     */
    public Long getSecondReduce() {
        return secondReduce;
    }

    /**
     * 设置第二件减 单位分
     *
     * @param secondReduce 第二件减 单位分
     */
    public void setSecondReduce(Long secondReduce) {
        this.secondReduce = secondReduce;
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
        PfGoodsPrice other = (PfGoodsPrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMemberPrice() == null ? other.getMemberPrice() == null : this.getMemberPrice().equals(other.getMemberPrice()))
            && (this.getSecondReduce() == null ? other.getSecondReduce() == null : this.getSecondReduce().equals(other.getSecondReduce()))
            && (this.getRecommendSeq() == null ? other.getRecommendSeq() == null : this.getRecommendSeq().equals(other.getRecommendSeq()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMemberPrice() == null) ? 0 : getMemberPrice().hashCode());
        result = prime * result + ((getSecondReduce() == null) ? 0 : getSecondReduce().hashCode());
        result = prime * result + ((getRecommendSeq() == null) ? 0 : getRecommendSeq().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", city=").append(city);
        sb.append(", price=").append(price);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", secondReduce=").append(secondReduce);
        sb.append(", recommendSeq=").append(recommendSeq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}