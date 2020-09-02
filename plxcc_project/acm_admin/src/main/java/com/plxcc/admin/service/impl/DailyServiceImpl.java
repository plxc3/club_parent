package com.plxcc.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.admin.entity.Daily;
import com.plxcc.admin.entity.vo.DateVo;
import com.plxcc.admin.mapper.DailyMapper;
import com.plxcc.admin.service.DailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-21
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {
    @Override
    public Result createRegister(String day) {

        Daily daily=new Daily();
        int count=baseMapper.createRegister(day);
        daily.setRegisterNum(count);
        daily.setDateCalculated(day);
        QueryWrapper<Daily> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("date_calculated",day);
//        baseMapper.delete(queryWrapper);
//        baseMapper.insert(daily);
        baseMapper.update(daily,queryWrapper);
        return Result.success().setMsg("生成成功");
    }

    @Override
    public Result getShowData(DateVo dateVo) {
        System.out.println(dateVo);
        String type=dateVo.getType();
        String begin=dateVo.getBegin();
        String end=dateVo.getEnd();
        if(type!=null&& StringUtils.isEmpty(type)){
            return Result.fail().setMsg("必须选择类型");
        }
        if(StringUtils.isEmpty(end)||StringUtils.isEmpty(begin)){
            return Result.fail().setMsg("必须选择开始时间和结尾时间");
        }
        QueryWrapper<Daily> queryWrapper=new QueryWrapper<>();
        queryWrapper.between("date_calculated",begin,end).orderByAsc("date_calculated");
//        queryWrapper.ge("date_calculated",begin).le("date_calculated",end);
        //选择只查的字段
        queryWrapper.select("date_calculated",type);

        List<Daily> dailies = baseMapper.selectList(queryWrapper);
        List<String> date_calculatedList=new ArrayList<>();
        List<Integer> numDataList=new ArrayList<>();
        for(Daily daily:dailies){
            date_calculatedList.add(daily.getDateCalculated());
            switch (type){
                case "register_num":
                    numDataList.add(daily.getRegisterNum());
                    break;
                case "login_num":
                    numDataList.add(daily.getLoginNum());
                    break;
                default:
                    break;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("numDataList",numDataList);
        map.put("date_calculatedList",date_calculatedList);
        return Result.success().setData(map);
    }

    @Override
    public Boolean createLogin(String day) {
        try{
            QueryWrapper<Daily> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("date_calculated",day).orderByAsc("date_calculated");
            queryWrapper.select("date_calculated","login_num","id");
            Daily daily=baseMapper.selectOne(queryWrapper);
            if(daily==null){
                Daily daily1=new Daily();
                daily1.setDateCalculated(day);
                daily1.setLoginNum(1);
                baseMapper.insert(daily1);
            }else {
                int count=daily.getLoginNum()+1;
                daily.setLoginNum(count);
                baseMapper.updateById(daily);
                System.out.println(daily);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
