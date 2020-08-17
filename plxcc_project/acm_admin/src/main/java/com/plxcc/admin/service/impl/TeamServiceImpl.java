package com.plxcc.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plxcc.admin.entity.Team;
import com.plxcc.admin.entity.vo.ItemVo;
import com.plxcc.admin.mapper.TeamMapper;
import com.plxcc.admin.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public Result addIteam(ItemVo itemVo) {
        if(itemVo.getCoachName()==null){
            return Result.fail().setMsg("教练不能为空");
        }
        if(itemVo.getName1()==null){
            return Result.fail().setMsg("必须有一个队员");
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
}
