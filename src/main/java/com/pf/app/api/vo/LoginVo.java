package com.pf.app.api.vo;

public class LoginVo implements VO {
    private String phoneNum;
    private String verificationCode;
    private Long recommendUserId;
    private String device;
    private String pushToken;

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginVo{");
        sb.append("phoneNum='").append(phoneNum).append('\'');
        sb.append(", verificationCode='").append(verificationCode).append('\'');
        sb.append(", recommendUserId=").append(recommendUserId);
        sb.append(", device='").append(device).append('\'');
        sb.append(", pushToken='").append(pushToken).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
