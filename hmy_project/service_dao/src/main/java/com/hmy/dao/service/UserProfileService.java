package com.hmy.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmy.dao.entity.UserProfile;
import com.plxcc.servicebase.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hmy
 * @since 2020-08-07
 */
public interface UserProfileService extends IService<UserProfile> {

    PageUtils queryPage(Map<String, Object> params);
}
