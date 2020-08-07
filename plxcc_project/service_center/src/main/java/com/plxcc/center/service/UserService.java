package com.plxcc.center.service;

import com.plxcc.center.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
public interface UserService extends IService<User> {

    Result login(LoginVo loginVo);
}
