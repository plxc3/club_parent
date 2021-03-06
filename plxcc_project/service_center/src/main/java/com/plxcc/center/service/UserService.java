package com.plxcc.center.service;

import com.plxcc.center.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.center.entity.vo.RegisterVo;
import com.plxcc.servicebase.common.Result;

import javax.servlet.http.HttpSession;

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

    Result register(RegisterVo registerVo);

    LoginInfoVo getUserInfo(String id);

    Boolean selectByPhone(String phone);

    Boolean selectByEmail(String email);

    Result loginOut(String id);
}
