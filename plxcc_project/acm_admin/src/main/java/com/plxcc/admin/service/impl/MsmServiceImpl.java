package com.plxcc.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.admin.service.MsmService;
import com.plxcc.admin.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @PackgeName: com.plxcc.admin.service.impl
 * @ClassName: MsmServiceImpl
 * @Author: plxc
 * Date: 2020/8/16 16:10
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
}
