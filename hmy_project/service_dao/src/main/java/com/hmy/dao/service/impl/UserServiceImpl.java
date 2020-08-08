package com.hmy.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmy.dao.entity.User;
import com.hmy.dao.entity.UserProfile;
import com.hmy.dao.entity.vo.LoginInfoVo;
import com.hmy.dao.entity.vo.LoginVo;
import com.hmy.dao.entity.vo.RegisterVo;
import com.hmy.dao.mapper.UserMapper;
import com.hmy.dao.service.UserProfileService;
import com.hmy.dao.service.UserService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.utils.MD5;
import com.plxcc.servicebase.utils.PageUtils;
import com.plxcc.servicebase.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserProfileService profileService;



    @Override
    public Result login(LoginVo loginVo) {
        String phone=loginVo.getPhone();
        String email=loginVo.getEmail();
        String password=loginVo.getPassword();


        //前端已经整合不会发送空的账号数据和密码，所以只需判断登陆方式或者是否密码账号是否错误
        if(!StringUtils.checkValNotNull(email)){
            //根据手机号查询用户是否存在并获取用户信息
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("phone",phone);
            User user=baseMapper.selectOne(queryWrapper);
            if(!StringUtils.checkValNotNull(user)){
                return Result.fail().setMsg("账户不存在");
            }
            //对passwor进行加密与获取的密码进行判断
            if(!user.getPassword().equals(MD5.encrypt(password))){
                return Result.fail().setMsg("账户或密码错误");
            }
            //判断用户是否禁用
            if(user.getIsDisable()){
                return Result.fail().setMsg("用户已经被禁用");
            }
            String token= JwtUtils.getJwtToken(user.getUserId(),user.getNickname(),user.getRole());

            return Result.success().setMsg("登陆成功").setData("token",token);

        }else {
            //根据邮箱查询用户是否存在并获取用户信息
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("email",email);
            User user=baseMapper.selectOne(queryWrapper);
            if(!StringUtils.checkValNotNull(user)){
                return Result.fail().setMsg("账户不存在");
            }
            //对passwor进行加密与获取的密码进行判断
            if(!user.getPassword().equals(MD5.encrypt(password))){
                return Result.fail().setMsg("账户或密码错误");
            }
            //判断用户是否禁用
            if(user.getIsDisable()){
                return Result.fail().setMsg("用户已经被禁用");
            }
            String token= JwtUtils.getJwtToken(user.getUserId(),user.getNickname(),user.getRole());

            return Result.success().setMsg("登陆成功").setData("token",token);
        }

    }

    @Override
    public Result register(RegisterVo registerVo) {
        //获取注册码
        String code=registerVo.getCode();
        String password=registerVo.getPassword();
        String email=registerVo.getEmail();
        String phone=registerVo.getPhone();
        if(!StringUtils.checkValNotNull(email)){
            String rediscode=redisTemplate.opsForValue().get(phone);
            if(!code.equals(rediscode)){
                return Result.fail().setMsg("短信验证码错误");
            }
            //判断用户是否存在
            QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
            userQueryWrapper.eq("phone",phone);
            int count=baseMapper.selectCount(userQueryWrapper);
            if(count>0){
                return Result.fail().setMsg("用户已经注册");
            }
            User user=new User();
            BeanUtils.copyProperties(registerVo,user);
            user.setPassword(MD5.encrypt(password));
            //若果插入成功，同时创建user档案表，插入user的id
            if(baseMapper.insert(user)>0){
                UserProfile userProfile=new UserProfile();
                userProfile.setUserId(user.getUserId());
                userProfile.setAvatar("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
                profileService.save(userProfile);
            }
            return Result.success().setMsg("注册成功");
        }
        else {
            String rediscode=redisTemplate.opsForValue().get(email);
            if(!code.equals(rediscode)){
                return Result.fail().setMsg("邮件验证码错误");
            }
            //判断用户是否存在
            QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
            userQueryWrapper.eq("email",email);
            int count=baseMapper.selectCount(userQueryWrapper);
            if(count>0){
                return Result.fail().setMsg("用户已经注册");
            }
            User user=new User();
            BeanUtils.copyProperties(registerVo,user);
            user.setPassword(MD5.encrypt(password));
            //若果插入成功，同时创建user档案表，插入user的id
            if(baseMapper.insert(user)>0){
                UserProfile userProfile=new UserProfile();
                userProfile.setUserId(user.getUserId());
                userProfile.setAvatar("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
                profileService.save(userProfile);
            }
            return Result.success().setMsg("注册成功");
        }
    }

    @Override
    public LoginInfoVo getUserInfo(String id) {
       LoginInfoVo infoVo=new LoginInfoVo();
        UserProfile byId = profileService.getById(id);
        if (byId!=null){
            BeanUtils.copyProperties(byId,infoVo);
        }
       return infoVo;
    }

    public PageUtils queryPage(Map<String, Object> params)
    {
        IPage<User> page = this.page(
                new Query<User>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }
}
