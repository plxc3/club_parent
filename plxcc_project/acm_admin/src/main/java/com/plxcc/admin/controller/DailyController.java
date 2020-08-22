package com.plxcc.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plxcc.admin.entity.Daily;
import com.plxcc.admin.entity.vo.DateVo;
import com.plxcc.admin.service.DailyService;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-21
 */
@RestController
@RequestMapping("/admin/daily")
public class DailyController {

    @Autowired
    private DailyService dailyService;

    /**
     * 查询某一天注册的人数,并查到数据库中
     */
    @GetMapping("/createRegister/{day}")
    public Result createRegister(@PathVariable String day){
        return dailyService.createRegister(day);
    }

    /**
     * 图表显示，返回两部分数据，日期json数据，数量json数组
     */
    @PostMapping("/showData")
    public Result showData(@RequestBody DateVo dateVo){
        return  dailyService.getShowData(dateVo);
    }


    /**
     * 记录登陆人数追加到数据中
     */
    @GetMapping("/createLogin/{day}")
    public Boolean createLogin(@PathVariable String day){
        return dailyService.createLogin(day);
    }


}

