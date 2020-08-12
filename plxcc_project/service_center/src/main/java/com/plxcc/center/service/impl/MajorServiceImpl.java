package com.plxcc.center.service.impl;

import com.alibaba.excel.EasyExcel;
import com.plxcc.center.entity.Major;
import com.plxcc.center.entity.vo.excel.MajorData;
import com.plxcc.center.mapper.MajorMapper;
import com.plxcc.center.service.MajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.center.utlis.MajorExcelListener;
import com.plxcc.servicebase.common.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-13
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {
    @Override
    public Result addMajorByExcel(MultipartFile file,MajorService majorService) {
        try{
            InputStream inputStream=file.getInputStream();
            //调用方法读取
            EasyExcel.read(inputStream,
                    MajorData.class,new MajorExcelListener(majorService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success().setMsg("添加成功");
    }
}
