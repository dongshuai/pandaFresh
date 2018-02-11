package com.pf.app.api.vo;

public class GetVerificationCodeVo implements VO {

    private String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "VerificationCodeVo{" +
                "phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
