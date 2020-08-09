package com.plxcc.center.controller;


import com.plxcc.center.entity.UserProfile;
import com.plxcc.center.service.UserProfileService;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/center/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService profileService;

    @GetMapping("/test/{id}")
    public Result test(@PathVariable String id){
        UserProfile userProfil=profileService.getById(id);
        return Result.success().setData("data",userProfil);

    }
}

