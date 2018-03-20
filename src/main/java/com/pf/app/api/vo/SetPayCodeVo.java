package com.pf.app.api.vo;

public class SetPayCodeVo implements VO {

    private String phoneNum;
    private String phoneCode;
    private String password;
    private String password1;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SetPayCodeVo{");
        sb.append("phoneNum='").append(phoneNum).append('\'');
        sb.append(", phoneCode='").append(phoneCode).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", password1='").append(password1).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
