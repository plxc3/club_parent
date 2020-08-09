package com.plxcc.center.service.impl;

import com.plxcc.center.entity.BannerList;
import com.plxcc.center.mapper.BannerListMapper;
import com.plxcc.center.service.BannerListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-09
 */
@Service
public class BannerListServiceImpl extends ServiceImpl<BannerListMapper, BannerList> implements BannerListService {
    @Override
    public Result getBannerList() {
        List<BannerList> banners=new ArrayList<>();
        banners=baseMapper.selectList(null);
        return Result.success().setMsg("轮播图列表").setData("banners",banners);
    }
}
