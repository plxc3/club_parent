package com.hmy.user.controller;

import com.hmy.user.entity.UserProfile;
import com.hmy.user.feign.UserFeignService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/dao/user-profile")
@RestController
public class UserProfileController
{
    @Autowired
    UserFeignService service;

    @GetMapping("/getByToken")
    @ApiOperation(value = "获取profile",tags = "user-profile")
    public Result getByToken(HttpServletRequest request) throws Exception
    {
        String id = JwtUtils.getMemberIdByJwtToken(request);
        if (!StringUtils.isEmpty(id)){
            return service.getById(id);
        }
        return Result.fail().setMsg("查询失败");
    }

    public Result update(@RequestBody UserProfile userProfile,HttpServletRequest request) throws Exception
    {
        String id = JwtUtils.getMemberIdByJwtToken(request);
        if (id!=null){
            if (!id.equals(userProfile.getUserId())){
                return Result.fail().setMsg("请先登录");
            }
        }
        return service.update(userProfile);
    }
}
