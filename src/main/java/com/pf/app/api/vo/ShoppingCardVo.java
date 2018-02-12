package com.pf.app.api.vo;

public class ShoppingCardVo implements VO {
    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 数量
     */
    private Integer amount;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
