package com.plxcc.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.center.entity.User;
import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.center.mapper.UserMapper;
import com.plxcc.center.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.utils.MD5;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Result login(LoginVo loginVo) {
        String phone=loginVo.getPhone();
        String email=loginVo.getEmail();
        String password=loginVo.getPassword();
        String code=loginVo.getCode();

        //前端已经整合不会发送空的账号数据和密码，所以只需判断登陆方式或者是否密码账号是否错误
        if(!StringUtils.checkValNotNull(email)){
            //根据手机号查询用户是否存在并获取用户信息
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("phone",phone);
            User user=baseMapper.selectOne(queryWrapper);
            if(!StringUtils.checkValNotNull(user)){
                return Result.fail().setMsg("账号不存在");
            }
            //对passwor进行加密与获取的密码进行判断
            if(!user.equals(MD5.encrypt(password))){
                return Result.fail().setMsg("账户或密码错误");
            }
            //判断用户是否禁用
            if(user.getIsDisable()){
                return Result.fail().setMsg("用户已经被禁用");
            }
            String token= JwtUtils.getJwtToken(user.getUserId(),user.getNickname(),user.getRole());

            return Result.success().setMsg("登陆成功").setData("token",token);

        }

        return Result.fail().setMsg("TODO");

    }
}
