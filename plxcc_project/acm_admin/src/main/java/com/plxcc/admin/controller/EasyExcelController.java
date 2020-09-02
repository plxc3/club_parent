package com.plxcc.admin.controller;

import com.plxcc.admin.entity.Team;
import com.plxcc.admin.entity.vo.TeamExcelVo;
import com.plxcc.admin.service.EasyExcelService;
import com.plxcc.admin.service.TeamService;
import com.plxcc.admin.utils.ExcelUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: com.plxcc.admin.controller
 * @ClassName: EasyExcelController
 * @Author: plxc
 * Date: 2020/9/2 12:43
 * project name: club_parent
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/easyexcel")
public class EasyExcelController {

    @Autowired
    private EasyExcelService easyExcelService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/testdownLoad")
    public void testdownLoad(HttpServletResponse response){
        //设置Excel表的名称
        String fileName = "User信息详情";
        //获得User实体类对象集合
        List<Team> teams = teamService.list();

        List<TeamExcelVo> teamExcelVos=new ArrayList<>();
        for (Team team:teams){
            TeamExcelVo te=new TeamExcelVo();
            BeanUtils.copyProperties(team,te);
            teamExcelVos.add(te);
        }


        //把数据写入到Excel表格中
      ExcelUtils.writeExcel(response,teamExcelVos,fileName,fileName,TeamExcelVo.class);


    }

}
