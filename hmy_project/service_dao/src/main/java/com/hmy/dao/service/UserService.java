package com.hmy.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmy.dao.entity.User;
import com.hmy.dao.entity.vo.LoginInfoVo;
import com.hmy.dao.entity.vo.LoginVo;
import com.hmy.dao.entity.vo.RegisterVo;
import com.plxcc.servicebase.common.Result;
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
public interface UserService extends IService<User> {

    Result login(LoginVo loginVo);

    Result register(RegisterVo registerVo);

    LoginInfoVo getUserInfo(String id);

    PageUtils queryPage(Map<String, Object> params);
}
