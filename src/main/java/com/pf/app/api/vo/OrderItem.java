package com.pf.app.api.vo;

public class OrderItem {

    /**
     * 商品主键
     */
    private Long goodsId;
    /**
     * 商品数量
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
