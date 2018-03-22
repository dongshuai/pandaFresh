package com.pf.app.api.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgUtil {

    private static final Logger logger = LoggerFactory.getLogger(MsgUtil.class);

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String accessKeyId = "LTAIfjgbr0iIwf6j";
    private static final String accessKeySecret = "6NAGdBFpyvLOnaKs2rzWX9LM8ELkDe";


    public static SendSmsResponse sendSms( String phoneNum, String templateCode, String templateParam ) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("熊猫生鲜");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
        //request.setTemplateParam("{\"code\":\"123\"}");
        request.setTemplateParam(templateParam);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        // request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }


    /**
     * 发送登录验证码
     * @param phoneNum
     * @param code
     */
    public static void sendLoginMsgCode(String phoneNum, String code) {
        StringBuffer stringBuffer = new StringBuffer("{\"code\":\"");
        stringBuffer.append(code).append("\"}");
        String templateParam = stringBuffer.toString();
        String templateCode = "SMS_126395010";
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSms(phoneNum, templateCode, templateParam);
        } catch (ClientException e) {
            e.printStackTrace();
            logger.error("发送短信失败，error：{}", e.getErrMsg());
        }

        if (!sendSmsResponse.getCode().equals("ok")) {
            printErrorLogs(sendSmsResponse);
        }

    }

    /**
     * 发送第三方绑定手机 验证码
     * @param phoneNum
     * @param code
     */
    public static void sendThirdBindPhoneMsgCode(String phoneNum, String code) {
        StringBuffer stringBuffer = new StringBuffer("{\"code\":\"");
        stringBuffer.append(code).append("\"}");
        String templateParam = stringBuffer.toString();
        String templateCode = "SMS_126405011";
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSms(phoneNum, templateCode, templateParam);
        } catch (ClientException e) {
            e.printStackTrace();
            logger.error("发送短信失败，error：{}", e.getErrMsg());
        }

        if (!sendSmsResponse.getCode().equals("ok")) {
            printErrorLogs(sendSmsResponse);
        }

    }

    /**
     * 发送修改支付密码 验证码
     * @param phoneNum
     * @param code
     */
    public static void sendModifyPayPasswordMsgCode(String phoneNum, String code) {
        StringBuffer stringBuffer = new StringBuffer("{\"code\":\"");
        stringBuffer.append(code).append("\"}");
        String templateParam = stringBuffer.toString();
        String templateCode = "SMS_126350250";
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSms(phoneNum, templateCode, templateParam);
        } catch (ClientException e) {
            e.printStackTrace();
            logger.error("发送短信失败，error：{}", e.getErrMsg());
        }

        if (!sendSmsResponse.getCode().equals("ok")) {
            printErrorLogs(sendSmsResponse);
        }

    }

    public static void sendModifyBindPhoneNumMsgCode(String phoneNum, String code) {
        StringBuffer stringBuffer = new StringBuffer("{\"code\":\"");
        stringBuffer.append(code).append("\"}");
        String templateParam = stringBuffer.toString();
        String templateCode = "SMS_126350249";
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSms(phoneNum, templateCode, templateParam);
        } catch (ClientException e) {
            e.printStackTrace();
            logger.error("发送短信失败，error：{}", e.getErrMsg());
        }

        if (!sendSmsResponse.getCode().equals("ok")) {
            printErrorLogs(sendSmsResponse);
        }

    }

    private static void printErrorLogs(SendSmsResponse sendSmsResponse){
        logger.error("Code={}", sendSmsResponse.getCode());
        logger.error("Message={}", sendSmsResponse.getMessage());
        logger.error("RequestId={}", sendSmsResponse.getRequestId());
        logger.error("BizId={}", sendSmsResponse.getBizId());
    }

    public static void main(String [] args){
        sendLoginMsgCode("13673680031","666666");

    }

}
