package com.plxcc.admin.controller;


import com.plxcc.admin.entity.Admin;
import com.plxcc.admin.service.AdminService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/admin/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * login
     */
    @ApiOperation(tags = {"admin"},value = "login")
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        return adminService.login(admin);
    }
    /**
     * 修改密码
     */
    @ApiOperation(tags = {"admin"},value = "修改密码")
    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody Admin admin){
        return adminService.changePassword(admin);
    }


}

