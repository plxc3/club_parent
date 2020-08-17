package com.plxcc.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plxcc.admin.entity.Admin;
import com.plxcc.admin.mapper.AdminMapper;
import com.plxcc.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.MD5;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public Result login(Admin admin) {
        String userName=admin.getUserName();
        String password=admin.getPassword();
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        Admin admin1=baseMapper.selectOne(queryWrapper);
        if(admin1==null){
            return Result.fail().setMsg("账号不存在");
        }
        password=MD5.encrypt(password);
        password=MD5.encrypt(password.substring(0,20));
        if(admin1.getPassword().equals(password)){
            return Result.success().setMsg("登陆成功").setData("id",admin1.getId());
        }
        return Result.fail().setMsg("账号或者密码错误");
    }

    @Override
    public Result changePassword(Admin admin) {
        String password=admin.getPassword();
        password=MD5.encrypt(password);
        password=MD5.encrypt(password.substring(0,20));
        admin.setPassword(password);
        baseMapper.updateById(admin);
        return Result.success().setMsg("修改成功");
    }
}
