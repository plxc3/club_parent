package com.plxcc.center.service;

import com.plxcc.center.entity.UserProfile;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
public interface UserProfileService extends IService<UserProfile> {

    Result updateAvatar(LoginInfoVo avatarvo);
}
