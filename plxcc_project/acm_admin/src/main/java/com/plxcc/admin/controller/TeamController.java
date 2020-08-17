package com.plxcc.admin.controller;


import com.plxcc.admin.entity.vo.ItemVo;
import com.plxcc.admin.service.TeamService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/admin/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * 队伍的创建
     * */
    @ApiOperation(tags = {"iteam"},value = "小组的添加接口")
    @PostMapping("/addIteam")
    public Result addIteam(@RequestBody ItemVo itemVo){
        return teamService.addIteam(itemVo);
    }
    /**
     * 队伍列表的获取
     */
    @ApiOperation(tags = {"iteam"},value = "小组列表获取")
    @GetMapping("/getList/{id}")
    public Result getListByPd(@PathVariable String id){
        return teamService.getListByPd(id);
    }
    /**
     * 队伍的更新
     */
    @ApiOperation(tags = {"iteam"},value = "小组更新")
    @PostMapping("/updateById")
    public  Result updateById(@RequestBody ItemVo itemVo){
        return teamService.updateTeamById(itemVo);
    }
    /**
     * 小组删除
     */
    @ApiOperation(tags = {"iteam"},value = "小组删除")
    @GetMapping("/deleted/{id}")
    public Result deletdByTeamId(@PathVariable String id ){
        return teamService.deletdByTeamId(id);
    }
    /**
     * 后台列表获取，两表关联
     */
    @ApiOperation(tags = {"iteam"},value = "后台小组列表获取")
    @GetMapping("/getAdminList")
    public Result getAdminList(){
        return teamService.getAdminList();
    }

    /**
     * 根据学校id返回一个学校的所有队伍
     */
    @ApiOperation(tags = {"iteam"},value = "学校页面的Excle")
    @GetMapping("/getFrontEndList/{id}")
    public Result getFrontEndList(@PathVariable String id){
        return teamService.getFrontEndList(id);
    }



}

