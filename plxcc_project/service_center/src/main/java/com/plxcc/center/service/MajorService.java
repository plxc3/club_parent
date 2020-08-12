package com.plxcc.center.service;

import com.plxcc.center.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.servicebase.common.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-13
 */
public interface MajorService extends IService<Major> {

    Result addMajorByExcel(MultipartFile file,MajorService majorService);
}
