package com.hmy.user.controller;

import com.hmy.user.entity.UserProfile;
import com.hmy.user.feign.UserProfileFeignService;
import com.plxcc.servicebase.common.PageParam;
import com.plxcc.servicebase.common.PageParamUtil;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/dao/user-profile")
@RestController
public class UserProfileController
{
    @Autowired
    UserProfileFeignService profileFeignService;

    @GetMapping("/getByToken")
    @ApiOperation(value = "获取profile",tags = "user-profile")
    public Result getByToken(HttpServletRequest request) throws Exception
    {
        String id = JwtUtils.getMemberIdByJwtToken(request);
        if (!StringUtils.isEmpty(id)){
            return profileFeignService.getById(id);
        }
        return Result.fail().setMsg("查询失败");
    }

    @PostMapping("/list")
    @ApiOperation(value = "分页查询profile",tags = "user-profile")
    public Result list(@RequestBody(required = false) PageParam param)
    {
        return profileFeignService.list(PageParamUtil.toMap(param));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新profile",tags = "user-profile")
    public Result update(@RequestBody UserProfile userProfile,HttpServletRequest request) throws Exception
    {
        String id = JwtUtils.getMemberIdByJwtToken(request);
        if (id!=null){
            if (!id.equals(userProfile.getUserId())){
                return Result.fail().setMsg("请先登录");
            }
        }
        return profileFeignService.update(userProfile);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "插入profile",tags = "user-profile")
    public Result insert(@RequestBody UserProfile userProfile)
    {
        return profileFeignService.insert(userProfile);
    }
}
