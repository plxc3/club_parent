package com.plxcc.center.controller;


import com.plxcc.center.service.MajorService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-13
 */
@RestController
@RequestMapping("/center/major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    /**
     * 添加专业，从Excel文件中读取
     */
    @ApiOperation(tags = {"major"},value = "从Excel文件中读取专业")
    @PostMapping("/addMajorByExcel")
    public Result addMajorByExcel(MultipartFile file){
        //上传过来的Excel文件
        return majorService.addMajorByExcel(file, majorService);
    }
    /**
     * 专业列表查询
     */
//    @ApiOperation(tags = {"major"},value = "从Excel文件中读取专业")
//    @GetMapping("/")


}

