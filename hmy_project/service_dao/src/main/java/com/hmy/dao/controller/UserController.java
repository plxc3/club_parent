package com.hmy.dao.controller;


import com.hmy.dao.entity.User;
import com.hmy.dao.entity.vo.LoginInfoVo;
import com.hmy.dao.entity.vo.LoginVo;
import com.hmy.dao.entity.vo.RegisterVo;
import com.hmy.dao.service.UserService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.utils.PageUtils;
import com.plxcc.servicebase.utils.ZTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hmy
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/dao/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo)
    {
        return userService.login(loginVo);
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterVo registerVo)
    {
        return userService.register(registerVo);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user)
    {
        return Result.success().setData("updated",userService.update(user,null));
    }

    @GetMapping("/getUserPage")
    public Result userList(@RequestParam Map<String, Object> params)
    {
        PageUtils pageUtils = userService.queryPage(params);
        List<?> list = pageUtils.getList();
        if (list!=null){
            for (User user:(List<User>)list){
                //清除密码
                user.setPassword(null);
            }
        }
        return Result.success().setData("page",pageUtils);
    }

    @GetMapping("/getUserInfoByToken")
    public Result getUserInfoByToken(HttpServletRequest request){
        //调用JWT工具类的方法，根据request对象获取头信息，返回用户id
        try {
            String id = JwtUtils.getMemberIdByJwtToken(request);
            LoginInfoVo infoVo=userService.getUserInfo(id);
            return Result.success().setData("loginInfo",infoVo);
        }catch (Exception e){
            e.printStackTrace();
            throw new ZTException(20001,"error");
        }
    }

    @GetMapping("/getUserById")
    public Result<User> getUserById(@RequestParam String id)
    {
        return Result.success().setData("user", userService.getById(id));
    }
}

