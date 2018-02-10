package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pf_user_bill_record")
public class PfUserBillRecord implements Serializable {
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
     * 抬头类型1：公司2：个人
     */
    private Byte type;

    /**
     * 公司名称或个人名称
     */
    @Column(name = "bill_name")
    private String billName;

    /**
     * 纳税人识别号
     */
    @Column(name = "tax_no")
    private String taxNo;

    /**
     * 金额：单位元
     */
    private Long amount;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

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
     * 获取抬头类型1：公司2：个人
     *
     * @return type - 抬头类型1：公司2：个人
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置抬头类型1：公司2：个人
     *
     * @param type 抬头类型1：公司2：个人
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取公司名称或个人名称
     *
     * @return bill_name - 公司名称或个人名称
     */
    public String getBillName() {
        return billName;
    }

    /**
     * 设置公司名称或个人名称
     *
     * @param billName 公司名称或个人名称
     */
    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    /**
     * 获取纳税人识别号
     *
     * @return tax_no - 纳税人识别号
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * 设置纳税人识别号
     *
     * @param taxNo 纳税人识别号
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    /**
     * 获取金额：单位元
     *
     * @return amount - 金额：单位元
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置金额：单位元
     *
     * @param amount 金额：单位元
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        PfUserBillRecord other = (PfUserBillRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getTaxNo() == null ? other.getTaxNo() == null : this.getTaxNo().equals(other.getTaxNo()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getTaxNo() == null) ? 0 : getTaxNo().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", billName=").append(billName);
        sb.append(", taxNo=").append(taxNo);
        sb.append(", amount=").append(amount);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}