package com.pf.app.api.vo;

import javax.persistence.Column;

public class AddrVo implements VO {


    /**
     * 收货人
     */
    private String receiver;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 收货地址
     */
    private String receiveAddr;

    /**
     * 楼号门牌
     */
    private String houseNumber;

    /**
     * 地址类型1：公司，2：住宅，3：学校,4:其他
     */
    private Byte type;

    /**
     * 是否是默认地址1：默认：0：非默认
     */
    private Boolean defaultFlag;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Boolean getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @Override
    public String toString() {
        return "AddrVo{" +
                "receiver='" + receiver + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", receiveAddr='" + receiveAddr + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", type=" + type +
                ", defaultFlag=" + defaultFlag +
                '}';
    }
}
