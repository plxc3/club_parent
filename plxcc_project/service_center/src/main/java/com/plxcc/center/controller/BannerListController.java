package com.plxcc.center.controller;


import com.plxcc.center.service.BannerListService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-09
 */
@RestController
@RequestMapping("/center/banner-list")
public class BannerListController {

    @Autowired
    private BannerListService bannerListService;

    @ApiOperation(tags = {"center"},value = "banner列表获取接口")
    @GetMapping("/getBanners")
    @Cacheable(value = "bannersSpace")
    public Result getBannerList(){
        return bannerListService.getBannerList();
    }

}

