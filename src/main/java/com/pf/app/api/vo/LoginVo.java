package com.pf.app.api.vo;

public class LoginVo implements VO {
    private String phoneNum;
    private String verificationCode;
    private Long recommendUserId;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Long getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(Long recommendUserId) {
        this.recommendUserId = recommendUserId;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", recommendUserId=" + recommendUserId +
                '}';
    }
}
