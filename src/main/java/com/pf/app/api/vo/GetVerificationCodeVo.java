package com.pf.app.api.vo;

public class GetVerificationCodeVo implements VO {

    private String phoneNum;
    /**
     * 类型 1:登录注册,:2:送第三方绑定手机 3:发送修改支付密码 4:修改绑定手机号码
     */
    private int type;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GetVerificationCodeVo{");
        sb.append("phoneNum='").append(phoneNum).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
