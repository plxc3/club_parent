package com.plxcc.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plxcc.admin.entity.Proxy;
import com.plxcc.admin.entity.Team;
import com.plxcc.admin.entity.vo.AdminListVo;
import com.plxcc.admin.entity.vo.ItemVo;
import com.plxcc.admin.mapper.TeamMapper;
import com.plxcc.admin.service.ProxyService;
import com.plxcc.admin.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.admin.utils.ComparatorSort;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

    @Autowired
    private ProxyService proxyService;


    @Override
    public Result addIteam(ItemVo itemVo) {

        if(itemVo.getTeamName()==null||itemVo.getTeamEngName()==null){
            return Result.fail().setMsg("请填写完整的队伍名称信息");
        }
        QueryWrapper<Team> teamQueryWrapper=new QueryWrapper<>();
       teamQueryWrapper.eq("teamName",itemVo.getTeamName()).or().eq("teamEngName",itemVo.getTeamEngName());
       int count=baseMapper.selectCount(teamQueryWrapper);
       if(count>0){
           return Result.fail().setMsg("队伍英文名或中文名已经被注册");
       }
        if(itemVo.getCoachName()==null||itemVo.getCoachPinyin()==null||itemVo.getCoachSex()==null||itemVo.getCoachTsize()==null){
            return Result.fail().setMsg("请填写完整教练信息");
        }
        if(itemVo.getName1()==null || itemVo.getPinyin1()==null||itemVo.getSex1()==null||itemVo.getTsize1()==null){
            return Result.fail().setMsg("必须有一个队员，请填写第一个队员的完整信息");
        }
        if((itemVo.getName2()==""&&itemVo.getPinyin2()=="")||(itemVo.getName2()==null&&itemVo.getPinyin2()==null)){
            itemVo.setPinyin2("");
            itemVo.setName2("");
            itemVo.setSex2("");
            itemVo.setTsize2("");
        }else{
            if(itemVo.getPinyin2()==""||itemVo.getName2()==""){
                return Result.fail().setMsg("请填写完整的队员2姓名信息");
            }else {
                if(itemVo.getSex2()==""||itemVo.getTsize2()==""){
                    return Result.fail().setMsg("请填写完整的队员2其他信息");
                }
            }
        }
        if((itemVo.getName3()==""&&itemVo.getPinyin3()=="")||(itemVo.getName3()==null&&itemVo.getPinyin3()==null)){
            itemVo.setPinyin3("");
            itemVo.setName3("");
            itemVo.setSex3("");
            itemVo.setTsize3("");
        }else{
            if(itemVo.getPinyin3()==""||itemVo.getName3()==""){
                return Result.fail().setMsg("请填写完整的队员3姓名信息");
            }else {
                if(itemVo.getSex3()==""||itemVo.getTsize3()==""){
                    return Result.fail().setMsg("请填写完整的队员3其他信息");
                }
            }
        }

        Team team=new Team();
        BeanUtils.copyProperties(itemVo,team);
        baseMapper.insert(team);
        return Result.success().setMsg("添加成功");
    }

    @Override
    public Result getListByPd(String proxyId) {
        System.out.println(proxyId);
        if(proxyId==null){
            return Result.fail().setMsg("前端信息异常");
        }
        QueryWrapper<Team> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("proxy_id",proxyId);
        List<Team> teams=baseMapper.selectList(queryWrapper);
        return Result.success().setMsg("学校小组列表").setData("teams",teams);
    }

    @Override
    public Result updateTeamById(ItemVo itemVo) {
        if(itemVo.getId()==null){
            return Result.fail().setMsg("前端信息异常");
        }
        if(itemVo.getTeamName()==""||itemVo.getTeamEngName()==""){
            return Result.fail().setMsg("请填写完整的队伍名称信息");
        }

        if(itemVo.getCoachName()==""||itemVo.getCoachPinyin()==""||itemVo.getCoachSex()==""||itemVo.getCoachTsize()==""){
            return Result.fail().setMsg("请填写完整教练信息");
        }
        if(itemVo.getName1()=="" || itemVo.getPinyin1()==""||itemVo.getSex1()==""||itemVo.getTsize1()==""){
            return Result.fail().setMsg("必须有一个队员，请填写第一个队员的完整信息");
        }

        if((itemVo.getPinyin2()==null&&itemVo.getName2()==null)||(itemVo.getPinyin2()==""&&itemVo.getName2()=="")){
            itemVo.setPinyin2("");
            itemVo.setName2("");
            itemVo.setSex2("");
            itemVo.setTsize2("");
        }else{
            if(itemVo.getPinyin2()==""||itemVo.getName2()==""){
                return Result.fail().setMsg("请填写完整的队员2姓名信息");
            }else {
                if(itemVo.getSex2()==""||itemVo.getTsize2()==""){
                    return Result.fail().setMsg("请填写完整的队员2其他信息");
                }
            }
        }

        if((itemVo.getPinyin3()==null&&itemVo.getName3()==null)||(itemVo.getPinyin3()==""&&itemVo.getName3()=="")){
            itemVo.setPinyin3("");
            itemVo.setName3("");
            itemVo.setSex3("");
            itemVo.setTsize3("");
        }else{
            if(itemVo.getPinyin3()==""||itemVo.getName3()==""){
                return Result.fail().setMsg("请填写完整的队员3姓名信息");
            }else {
                if(itemVo.getSex3()==""||itemVo.getTsize3()==""){
                    return Result.fail().setMsg("请填写完整的队员3其他信息");
                }
            }
        }
        String id=itemVo.getId();
        QueryWrapper<Team> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        int count=baseMapper.selectCount(queryWrapper);
        if(count==0){
            return Result.fail().setMsg("小组不存在");
        }
        Team team=baseMapper.selectById(id);
        BeanUtils.copyProperties(itemVo,team);
        baseMapper.updateById(team);
        return Result.success().setMsg("修改成功");
    }

    @Override
    public Result deletdByTeamId(String id) {
        System.out.println(baseMapper.deleteById(id));
        return Result.success().setMsg("删除成功");
    }

    @Override
    public Result getAdminList() {
        List<Team> teamList=new ArrayList<>();
        List<AdminListVo> adminListVoList=new ArrayList<>();
        teamList=baseMapper.selectList(null);
        for(Team team:teamList){
            AdminListVo adminVo=new AdminListVo();
            Proxy proxy=proxyService.getById(team.getProxyId());
            BeanUtils.copyProperties(proxy,adminVo);
            BeanUtils.copyProperties(team,adminVo);
            adminListVoList.add(adminVo);
        }

        Collections.sort(adminListVoList,new ComparatorSort());
//
//        for(AdminListVo ad:adminListVoList){
//            System.out.println(ad.getUniName());
//        }


    return Result.success().setMsg("队伍列表").setData("TeamList",adminListVoList);
    }

    @Override
    public Result getFrontEndList(String id) {
        List<AdminListVo> adminListVoList=new ArrayList<>();
        List<Team> teams=new ArrayList<>();
        QueryWrapper<Team> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("proxy_id",id);
        teams=baseMapper.selectList(queryWrapper);
        for(Team team:teams){
            AdminListVo adminVo=new AdminListVo();
            BeanUtils.copyProperties(team,adminVo);
            Proxy proxy=proxyService.getById(id);
            BeanUtils.copyProperties(proxy,adminVo);
            adminListVoList.add(adminVo);
        }
        return Result.success().setData("TeamList",adminListVoList);
    }
}
