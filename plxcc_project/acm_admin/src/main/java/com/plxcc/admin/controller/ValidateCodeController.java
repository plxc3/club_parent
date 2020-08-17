package com.plxcc.admin.controller;


import com.plxcc.admin.entity.vo.CheckImgCodeVo;
import com.plxcc.admin.utils.ImgValidateCodeUtil;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/admin/code")
public class ValidateCodeController {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 生成图片验证码
     * @return
     */
    @GetMapping("/getImgCode")
    @ApiOperation(tags = {"imgcode"},value = "生产图片验证码")
    public Result  getImgCode() {

        Map<String, String> result = new HashMap<>();
        try {
            // 获取 4位数验证码
            result= ImgValidateCodeUtil.getImgCodeBaseCode(4);
            // 将验证码存入redis 中（有效时长5分钟）
            cacheImgCode(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Result.success().setData("result",result);
    }
    /**
     * 校验验证码
     * imgCodeKey为从redis数据获取图片验证码
     * @param
     * @param
     * @return
     */
    @PostMapping("/checkImgCode")
    @ApiOperation(tags = {"imgcode"},value = "验证码校验")
    public Result checkImgCode(@RequestBody CheckImgCodeVo checkImgCodeVo) {
        String cacheCode = redisTemplate.opsForValue().get(checkImgCodeVo.getImgCodeKey());
        if (null == cacheCode) {
            return Result.fail().setMsg("图片验证码已过期，请重新获取");
        }
        if (cacheCode.equals(checkImgCodeVo.getImgCode().toLowerCase())) {
            return Result.success().setMsg("图片验证码输入正确");
        }
        return Result.fail().setMsg("图片验证码输入错误");

    }

    /**
     * 将验证码存入redis 中
     * @param result
     */
    public void cacheImgCode(Map<String, String> result) {
        String imgCode = result.get("imgCode");
        UUID randomUUID = UUID.randomUUID();
        String imgCodeKey = randomUUID.toString();
//        System.out.println("imgCodeKey:" + imgCodeKey);
        // 图片验证码有效时间 ：5 分钟
        redisTemplate.opsForValue().set(imgCodeKey, imgCode, 5, TimeUnit.MINUTES);
        result.put("imgCodeKey", imgCodeKey);
    }
}
