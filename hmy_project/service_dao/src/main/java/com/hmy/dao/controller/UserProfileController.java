package com.hmy.dao.controller;


import com.hmy.dao.service.UserProfileService;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}

