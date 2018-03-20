package com.pf.app.api.vo;

public class OrderPayVo implements VO {
    /**
     * 支付密码
     */
    private String password;
    /**
     * 商品主键字符串 格式 goodsId,goodsId
     */
    private String goodsIds;
    /**
     * 订单总价
     */
    private Long amount;
    /**
     * 支付类型
     */
    private Byte payType;
    /**
     * 使用红包数量
     */
    private Long redbag;
    /**
     * 优惠券主键
     */
    private Long voucherId;
    /**
     * 优惠券面额
     */
    private Long voucher;
    /**
     * 运费
     */
    private Long deliverFee;

    /**
     * 实时达送达时间
     */
    private String realTimeArrivalTime;

    /**
     * 预售订单售货时间
     */
    private String preSaleArrivalTime;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Long getRedbag() {
        return redbag;
    }

    public void setRedbag(Long redbag) {
        this.redbag = redbag;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Long getVoucher() {
        return voucher;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    public Long getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Long deliverFee) {
        this.deliverFee = deliverFee;
    }

    public String getRealTimeArrivalTime() {
        return realTimeArrivalTime;
    }

    public void setRealTimeArrivalTime(String realTimeArrivalTime) {
        this.realTimeArrivalTime = realTimeArrivalTime;
    }

    public String getPreSaleArrivalTime() {
        return preSaleArrivalTime;
    }

    public void setPreSaleArrivalTime(String preSaleArrivalTime) {
        this.preSaleArrivalTime = preSaleArrivalTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderPayVo{");
        sb.append("goodsIds='").append(goodsIds).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", payType=").append(payType);
        sb.append(", redbag=").append(redbag);
        sb.append(", voucherId=").append(voucherId);
        sb.append(", voucher=").append(voucher);
        sb.append(", deliverFee=").append(deliverFee);
        sb.append('}');
        return sb.toString();
    }
}