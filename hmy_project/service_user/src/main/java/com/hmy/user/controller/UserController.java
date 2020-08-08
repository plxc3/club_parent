package com.hmy.user.controller;

import com.hmy.user.entity.User;
import com.hmy.user.feign.UserFeignService;
import com.plxcc.servicebase.common.PageParam;
import com.plxcc.servicebase.common.PageParamUtil;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.config.PermissionVerify;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserFeignService userFeignService;

    @GetMapping("list")
    @ApiOperation(value = "分页查询用户列表",tags = {"user"})
    @PermissionVerify()
    public Result userList(@RequestBody(required = false) PageParam param)
    {
        return userFeignService.userList(PageParamUtil.toMap(param));
    }

    @GetMapping("/getUserById")
    @ApiOperation(value = "获取一个用户",tags = {"user"})
    public Result getUserById(@RequestParam String id)
    {
        User user = userFeignService.getUserById(id).getData().get("user");
        if (user!=null){
            user.setPassword(null);
            return Result.success().setData("user",user);
        }
        return Result.fail().setMsg("没有此用户");
    }

}
