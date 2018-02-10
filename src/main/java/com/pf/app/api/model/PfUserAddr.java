package com.pf.app.api.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pf_user_addr")
public class PfUserAddr implements Serializable {
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
     * 收货人
     */
    private String receiver;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 收货地址
     */
    @Column(name = "receive_addr")
    private String receiveAddr;

    /**
     * 楼号门牌
     */
    @Column(name = "house_number")
    private String houseNumber;

    /**
     * 地址类型1：公司，2：住宅，3：学校,4:其他
     */
    private Byte type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否是默认地址1：默认：0：非默认
     */
    @Column(name = "default_flag")
    private Boolean defaultFlag;

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
     * 获取收货人
     *
     * @return receiver - 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货人
     *
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取收货地址
     *
     * @return receive_addr - 收货地址
     */
    public String getReceiveAddr() {
        return receiveAddr;
    }

    /**
     * 设置收货地址
     *
     * @param receiveAddr 收货地址
     */
    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr == null ? null : receiveAddr.trim();
    }

    /**
     * 获取楼号门牌
     *
     * @return house_number - 楼号门牌
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * 设置楼号门牌
     *
     * @param houseNumber 楼号门牌
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber == null ? null : houseNumber.trim();
    }

    /**
     * 获取地址类型1：公司，2：住宅，3：学校,4:其他
     *
     * @return type - 地址类型1：公司，2：住宅，3：学校,4:其他
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置地址类型1：公司，2：住宅，3：学校,4:其他
     *
     * @param type 地址类型1：公司，2：住宅，3：学校,4:其他
     */
    public void setType(Byte type) {
        this.type = type;
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

    /**
     * 获取是否是默认地址1：默认：0：非默认
     *
     * @return default_flag - 是否是默认地址1：默认：0：非默认
     */
    public Boolean getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否是默认地址1：默认：0：非默认
     *
     * @param defaultFlag 是否是默认地址1：默认：0：非默认
     */
    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
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
        PfUserAddr other = (PfUserAddr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getReceiveAddr() == null ? other.getReceiveAddr() == null : this.getReceiveAddr().equals(other.getReceiveAddr()))
            && (this.getHouseNumber() == null ? other.getHouseNumber() == null : this.getHouseNumber().equals(other.getHouseNumber()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDefaultFlag() == null ? other.getDefaultFlag() == null : this.getDefaultFlag().equals(other.getDefaultFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getReceiveAddr() == null) ? 0 : getReceiveAddr().hashCode());
        result = prime * result + ((getHouseNumber() == null) ? 0 : getHouseNumber().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDefaultFlag() == null) ? 0 : getDefaultFlag().hashCode());
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
        sb.append(", receiver=").append(receiver);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", city=").append(city);
        sb.append(", receiveAddr=").append(receiveAddr);
        sb.append(", houseNumber=").append(houseNumber);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", defaultFlag=").append(defaultFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}