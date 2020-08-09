package com.plxcc.center.service;

import com.plxcc.center.entity.BannerList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-09
 */
public interface BannerListService extends IService<BannerList> {

    Result getBannerList();
}
