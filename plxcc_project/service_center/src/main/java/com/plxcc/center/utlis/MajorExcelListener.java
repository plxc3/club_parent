package com.plxcc.center.utlis;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plxcc.center.entity.Major;
import com.plxcc.center.entity.vo.excel.MajorData;
import com.plxcc.center.service.MajorService;
import com.plxcc.servicebase.exception.ZTException;

import java.util.Map;

/**
 * @PackgeName: com.plxcc.center.utlis
 * @ClassName: MajorExcelListener
 * @Author: plxc
 * Date: 2020/8/13 5:09
 * project name: club_parent
 * @Version:
 * @Description:
 */
public class MajorExcelListener extends AnalysisEventListener<MajorData> {

    //SubjectExcelListener不能交给spring管理，需要自己手动new，不能注入其他对象
    //不能实现数据库操作,可通过构造函数传递

    private MajorService majorService;

    public MajorExcelListener(MajorService majorService){
        this.majorService=majorService;
    }

    //判断学院不能重复添加
    private Major collegeExits(MajorService majorService,String name){
        QueryWrapper<Major> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",'0');
        Major college=majorService.getOne(queryWrapper);
        return college;
    }

    //判断专业不能重复添加
    private Major majorExits(MajorService majorService,String name,String pid){
        QueryWrapper<Major> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        Major major=majorService.getOne(queryWrapper);
        return major;
    }

    @Override
    public void invoke(MajorData data, AnalysisContext context) {
        if(data==null){
            throw new ZTException(20001,"文件为空");
        }
        //一行一行去读取Excel内容,第一个值为一级分类，第二个值为二级分类
        Major college=this.collegeExits(majorService,data.getCollege());
        if(college==null){
            //避免空指针异常,同时引用mybatisplus的全局主键生成策略
            college=new Major();
            college.setParentId("0");
            college.setTitle(data.getCollege());
            majorService.save(college);
        }
        Major major=this.majorExits(majorService,data.getMajor(),college.getId());
        if(major==null){
            major=new Major();
            major.setTitle(data.getMajor());
            major.setParentId(college.getId());
            majorService.save(major);

        }

    }

    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }

    //读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
