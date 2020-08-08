package com.hmy.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmy.dao.entity.UserProfile;
import com.hmy.dao.mapper.UserProfileMapper;
import com.hmy.dao.service.UserProfileService;
import com.plxcc.servicebase.utils.PageUtils;
import com.plxcc.servicebase.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hmy
 * @since 2020-08-07
 */
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements UserProfileService {
    @Override
    public PageUtils queryPage(Map<String, Object> params)
    {
        IPage<UserProfile> page = this.page(
                new Query<UserProfile>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }
}
