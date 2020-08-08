package com.plxcc.aliyun.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.aliyun.service.MsmService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.RandomUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: com.plxcc.aliyun.controller
 * @ClassName: MsmController
 * @Author: plxc
 * Date: 2020/8/7 22:54
 * project name: club_parent
 * @Version:
 * @Description:阿里云短信服务
 */
@RestController
@RequestMapping("/oss/msm")
public class MsmController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 发送短信验证码的方法
     */
    @ApiOperation(tags = {"oss"},value = "短信验证码发送接口")
    @GetMapping("/send/{phone}")
    public Result sendMsm(@PathVariable String phone) {
        //1.从redis中获取验证码，如果获取直接返回
        String code = redisTemplate.opsForValue().get(phone);
        if (StringUtils.checkValNotNull(code)) {
            return Result.success().setMsg("验证码早发了");
        }
        //2.如果获取不到，进行阿里云发送

        //生成随机的数值，传递给阿里云进行发送
        code = RandomUtil.getFourBitRandom();

        Map<String, Object> param = new HashMap<>();

        param.put("code", code);

        Boolean issend = msmService.sendCode(param, phone);

        if (issend) {
            //发送成功，把code放到redis中，并设置过期时间
            redisTemplate.opsForValue().set(phone, code, 15, TimeUnit.MINUTES);
            return Result.success().setMsg("短信验证发送成功");
        }

        return Result.fail().setMsg("短信验证码发送失败");
    }

    /**
     * 发送邮件验证码
     */
    @ApiOperation(tags = {"oss"},value = "邮件验证码发送接口")
    @GetMapping("/sendEmail/{email}")
    public Result sendEmail(@PathVariable String email){
        //1.从redis中获取验证码，如果获取直接返回
        String code = redisTemplate.opsForValue().get(email);
        if (StringUtils.checkValNotNull(code)) {
            return Result.success().setMsg("验证码早发了");
        }
        //2.如果获取不到，进行阿里云发送

        //生成随机的数值，传递给阿里云进行发送
        code = RandomUtil.getFourBitRandom();
        msmService.sendEmail(email,code);
        //发送成功，把code放到redis中，并设置过期时间
        redisTemplate.opsForValue().set(email, code, 15, TimeUnit.MINUTES);
        return Result.success().setMsg("验证码已发送");

    }


}
