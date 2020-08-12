package com.plxcc.center.service.impl;

import com.plxcc.center.entity.UserProfile;
import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.center.mapper.UserProfileMapper;
import com.plxcc.center.service.UserProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements UserProfileService {
    @Override
    public Result updateAvatar(LoginInfoVo avatarvo) {
        UserProfile userProfile=baseMapper.selectById(avatarvo.getUserId());
        BeanUtils.copyProperties(avatarvo,userProfile);
        baseMapper.updateById(userProfile);
        return Result.success().setMsg("头像修改成功");
    }
}
