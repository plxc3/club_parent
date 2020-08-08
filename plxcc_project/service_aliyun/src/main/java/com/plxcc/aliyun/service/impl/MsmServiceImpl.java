package com.plxcc.aliyun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.aliyun.service.MsmService;
import com.plxcc.aliyun.utils.ConstantPropertiesUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * @PackgeName: com.plxcc.aliyun.service.impl
 * @ClassName: MsmServiceImpl
 * @Author: plxc
 * Date: 2020/8/7 22:56
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Service
public class MsmServiceImpl implements MsmService {



    @Override
    public Boolean sendCode(Map<String, Object> param, String phone) {
        if(!StringUtils.checkValNotNull(phone)) {return false;}
        DefaultProfile profile =
                DefaultProfile.getProfile("default", ConstantPropertiesUtils.KEY_ID, ConstantPropertiesUtils.KEY_SERCERT);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();

        request.setSysMethod(MethodType.POST);

        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //设置发送的相关参数
        //手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //设置签名
        request.putQueryParameter("SignName", "我的社团管理网站");
        //设置模板
        request.putQueryParameter("TemplateCode", "SMS_198672680");
        //验证码
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try {
            //最终发送
            CommonResponse response= client.getCommonResponse(request);
            boolean result=response.getHttpResponse().isSuccess();
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void sendEmail(String email,String code) {

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        //下面填写密钥
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ConstantPropertiesUtils.KEY_ID, ConstantPropertiesUtils.KEY_SERCERT);
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        //使用https加密连接
        request.setProtocol(com.aliyuncs.http.ProtocolType.HTTPS);
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("plxcc@plxcc.top");
            request.setFromAlias("plxcc");
            request.setAddressType(1);
            //可以不需要
            //request.setTagName("控制台创建的标签");
            //是否需要回信功能
            request.setReplyToAddress(true);
            request.setToAddress(email);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject("社团邮箱注册");
            ClassPathResource mailTemplate = new ClassPathResource("static/01.html");
            System.out.println(mailTemplate);
            Scanner scanner = new Scanner(mailTemplate.getInputStream());
            String htmlBody = "";
            while (scanner.hasNextLine()){
                htmlBody += scanner.nextLine() + System.getProperty("line.separator");
            }
            htmlBody = htmlBody.replace("[code]", code);
            request.setHtmlBody(htmlBody);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
