package com.plxcc.admin.controller;


import com.plxcc.admin.entity.Manager;
import com.plxcc.admin.service.ManagerService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-21
 */
@RestController
@RequestMapping("/admin/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    private String id="1";

    /**
     * 关闭注册
     */
    @ApiOperation(tags = {"manager"},value = "关闭注册")
    @GetMapping("/closeRegister")
    public Result closeRegister(){
        Manager manager=managerService.getById(id);
        manager.setManager(false);
        managerService.updateById(manager);
        return Result.success().setMsg("注册功能已关闭");
    }
    /**
     * 打开注册
     */
    @ApiOperation(tags = {"manager"},value = "打开注册")
    @GetMapping("/openRegister")
    public Result openRegister(){
        Manager manager=managerService.getById(id);
        manager.setManager(true);
        managerService.updateById(manager);
        return Result.success().setMsg("注册功能以及打开");
    }
    /**
     *
     */
    @ApiOperation(tags = {"manager"},value = "")
    @GetMapping("/select")
    public Result select(){
        Manager manager=managerService.getById(id);
        return  Result.success().setData("manager",manager);
    }


}

