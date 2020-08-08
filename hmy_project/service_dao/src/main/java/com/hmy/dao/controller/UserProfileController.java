package com.hmy.dao.controller;


import com.hmy.dao.entity.UserProfile;
import com.hmy.dao.service.UserProfileService;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hmy
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/dao/user-profile")
public class UserProfileController {

    @Autowired
    UserProfileService service;

    @GetMapping("/getById")
    public Result getById(@RequestParam String id)
    {
        return Result.success().setData("profile",service.getById(id));
    }

    @GetMapping("/getPage")
    public Result getPage(@RequestParam Map<String,Object> params)
    {
        return Result.success().setData("page",service.queryPage(params));
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserProfile userProfile)
    {
        boolean update = service.update(userProfile, null);
        if (update){
            return Result.success().setMsg("/更新成功");
        }
        return Result.fail().setMsg("更新失败");
    }

}

