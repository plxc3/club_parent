package com.plxcc.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.admin.service.MsmService;
import com.plxcc.admin.service.ProxyService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.RandomUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: com.plxcc.admin.controller
 * @ClassName: MsmController
 * @Author: plxc
 * Date: 2020/8/16 16:08
 * project name: club_parent
 * @Version:
 * @Description: 发送手机注册短信
 */
@RestController
@RequestMapping("/admin/msm")
public class MsmController {

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 发送手机注册短信
     */
    @ApiOperation(tags = {"手机号发送短信验证码接口"},value = "参数为手机号")
    @GetMapping("/send/{phone}")
    public Result sendMsm(@PathVariable String phone){
        //0.判断手机号是否在数据库中注册
        if(!proxyService.getByPhone(phone)){
            return Result.fail().setMsg("手机号已经注册");
        }
        //1.从redis中获取验证码，如果获取直接返回
        String code=redisTemplate.opsForValue().get(phone);
        if(StringUtils.checkValNotNull(code)){
            return Result.success().setMsg("验证码已发送");
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

}
