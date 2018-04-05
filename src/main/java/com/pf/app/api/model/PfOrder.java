package com.pf.app.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "pf_order")
public class PfOrder implements Serializable {

    @Transient
    private List<PfShoppingCart> goodsList;
    @Transient
    private List<PfDelivery> deliveryList;
    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public List<PfShoppingCart> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<PfShoppingCart> goodsList) {
        this.goodsList = goodsList;
    }

    public List<PfDelivery> getDeliveryList() {
        return deliveryList;
    }

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 订单归属用户
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 交易流水号
     */
    @Column(name = "deal_stream")
    private String dealStream;

    /**
     * 订单总金额：单位分
     */
    private Long amount;

    /**
     * 订单实际支付金额
     */
    @Column(name = "real_amount")
    private Long realAmount;

    /**
     * 运费 单位：分
     */
    @Column(name = "deliver_fee")
    private Long deliverFee;

    /**
     * 支付类型：1：支付宝，2：微信，3，余额
     */
    @Column(name = "pay_type")
    private Byte payType;

    /**
     * 红包 单位：分
     */
    private Long redbag;

    /**
     * 优惠券主键
     */
    @Column(name = "voucher_id")
    private Long voucherId;

    /**
     * 优惠券 单位：分
     */
    private Long voucher;

    public void setDeliveryList(List<PfDelivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    /**
     * 订单支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 是否已开票1：未开票2：已开票
     */
    @Column(name = "bill_flag")
    private Byte billFlag;

    /**
     * 开票主键主键
     */
    @Column(name = "bill_id")
    private Long billId;

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
     * 获取订单归属用户
     *
     * @return user_id - 订单归属用户
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置订单归属用户
     *
     * @param userId 订单归属用户
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取订单号
     *
     * @return order_num - 订单号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号
     *
     * @param orderNum 订单号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 获取交易流水号
     *
     * @return deal_stream - 交易流水号
     */
    public String getDealStream() {
        return dealStream;
    }

    /**
     * 设置交易流水号
     *
     * @param dealStream 交易流水号
     */
    public void setDealStream(String dealStream) {
        this.dealStream = dealStream == null ? null : dealStream.trim();
    }

    /**
     * 获取订单总金额：单位分
     *
     * @return amount - 订单总金额：单位分
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置订单总金额：单位分
     *
     * @param amount 订单总金额：单位分
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取订单实际支付金额
     *
     * @return real_amount - 订单实际支付金额
     */
    public Long getRealAmount() {
        return realAmount;
    }

    /**
     * 设置订单实际支付金额
     *
     * @param realAmount 订单实际支付金额
     */
    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * 获取运费 单位：分
     *
     * @return deliver_fee - 运费 单位：分
     */
    public Long getDeliverFee() {
        return deliverFee;
    }

    /**
     * 设置运费 单位：分
     *
     * @param deliverFee 运费 单位：分
     */
    public void setDeliverFee(Long deliverFee) {
        this.deliverFee = deliverFee;
    }

    /**
     * 获取支付类型：1：支付宝，2：微信，3，余额
     *
     * @return pay_type - 支付类型：1：支付宝，2：微信，3，余额
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 设置支付类型：1：支付宝，2：微信，3，余额
     *
     * @param payType 支付类型：1：支付宝，2：微信，3，余额
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * 获取红包 单位：分
     *
     * @return redbag - 红包 单位：分
     */
    public Long getRedbag() {
        return redbag;
    }

    /**
     * 设置红包 单位：分
     *
     * @param redbag 红包 单位：分
     */
    public void setRedbag(Long redbag) {
        this.redbag = redbag;
    }

    /**
     * 获取优惠券主键
     *
     * @return voucher_id - 优惠券主键
     */
    public Long getVoucherId() {
        return voucherId;
    }

    /**
     * 设置优惠券主键
     *
     * @param voucherId 优惠券主键
     */
    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    /**
     * 获取优惠券 单位：分
     *
     * @return voucher - 优惠券 单位：分
     */
    public Long getVoucher() {
        return voucher;
    }

    /**
     * 设置优惠券 单位：分
     *
     * @param voucher 优惠券 单位：分
     */
    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单支付时间
     *
     * @return pay_time - 订单支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置订单支付时间
     *
     * @param payTime 订单支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取是否已开票1：未开票2：已开票
     *
     * @return bill_flag - 是否已开票1：未开票2：已开票
     */
    public Byte getBillFlag() {
        return billFlag;
    }

    /**
     * 设置是否已开票1：未开票2：已开票
     *
     * @param billFlag 是否已开票1：未开票2：已开票
     */
    public void setBillFlag(Byte billFlag) {
        this.billFlag = billFlag;
    }

    /**
     * 获取开票主键主键
     *
     * @return bill_id - 开票主键主键
     */
    public Long getBillId() {
        return billId;
    }

    /**
     * 设置开票主键主键
     *
     * @param billId 开票主键主键
     */
    public void setBillId(Long billId) {
        this.billId = billId;
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
        PfOrder other = (PfOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getDealStream() == null ? other.getDealStream() == null : this.getDealStream().equals(other.getDealStream()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getRealAmount() == null ? other.getRealAmount() == null : this.getRealAmount().equals(other.getRealAmount()))
            && (this.getDeliverFee() == null ? other.getDeliverFee() == null : this.getDeliverFee().equals(other.getDeliverFee()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getRedbag() == null ? other.getRedbag() == null : this.getRedbag().equals(other.getRedbag()))
            && (this.getVoucherId() == null ? other.getVoucherId() == null : this.getVoucherId().equals(other.getVoucherId()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getBillFlag() == null ? other.getBillFlag() == null : this.getBillFlag().equals(other.getBillFlag()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getDealStream() == null) ? 0 : getDealStream().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getRealAmount() == null) ? 0 : getRealAmount().hashCode());
        result = prime * result + ((getDeliverFee() == null) ? 0 : getDeliverFee().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getRedbag() == null) ? 0 : getRedbag().hashCode());
        result = prime * result + ((getVoucherId() == null) ? 0 : getVoucherId().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getBillFlag() == null) ? 0 : getBillFlag().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
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
        sb.append(", orderNum=").append(orderNum);
        sb.append(", dealStream=").append(dealStream);
        sb.append(", amount=").append(amount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", deliverFee=").append(deliverFee);
        sb.append(", payType=").append(payType);
        sb.append(", redbag=").append(redbag);
        sb.append(", voucherId=").append(voucherId);
        sb.append(", voucher=").append(voucher);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", billFlag=").append(billFlag);
        sb.append(", billId=").append(billId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}