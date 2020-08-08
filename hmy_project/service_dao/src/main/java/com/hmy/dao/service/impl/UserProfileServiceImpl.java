package com.hmy.dao.service.impl;

import com.hmy.dao.entity.UserProfile;
import com.hmy.dao.mapper.UserProfileMapper;
import com.hmy.dao.service.UserProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
