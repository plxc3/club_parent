package com.plxcc.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.plxcc.admin.entity.Proxy;
import com.plxcc.admin.entity.Team;
import com.plxcc.admin.entity.vo.InfoVo;
import com.plxcc.admin.entity.vo.LoginVo;
import com.plxcc.admin.entity.vo.RegisterVo;
import com.plxcc.admin.mapper.ProxyMapper;
import com.plxcc.admin.service.ProxyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plxcc.admin.service.TeamService;
import com.plxcc.admin.utils.SchoolSort;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.utils.MD5;
import com.plxcc.servicebase.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.query.ExampleQueryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-16
 */
@Service
public class ProxyServiceImpl extends ServiceImpl<ProxyMapper, Proxy> implements ProxyService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProxyService proxyService;


    @Override
    public Boolean getByPhone(String phone) {
        Proxy proxy=new Proxy();
        QueryWrapper<Proxy> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        int count=baseMapper.selectCount(queryWrapper);
        if(count>0){
            return false;
        }
        return true;
    }

    @Override
    public Result register(RegisterVo registerVo) {
        //获取注册码(必要的注册信息)
        String code=registerVo.getCode();
        String password=registerVo.getPassword();
        String phone=registerVo.getPhone();

        //判断必要元素不能为空
        if(code==null){
            return Result.fail().setMsg("短信验证码为空");
        }

        //判断用户是否存在
        QueryWrapper<Proxy> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        int count=baseMapper.selectCount(queryWrapper);
        //判断短信验证码是否存在
        String rediscode=redisTemplate.opsForValue().get(phone);
        if(!code.equals(rediscode)){
            return Result.fail().setMsg("短信验证码错误");
        }
        if(count>0){
            return Result.fail().setMsg("用户已经注册");
        }
        QueryWrapper<Proxy> schoolQuerry=new QueryWrapper<>();
        schoolQuerry.eq("uniName",registerVo.getUniName());
        count=baseMapper.selectCount(schoolQuerry);
        if(count>0){
            return Result.fail().setMsg("学校已经注册");
        }
        Proxy proxy=new Proxy();
        BeanUtils.copyProperties(registerVo,proxy);
        //进行密码加密,2次
        password= MD5.encrypt(password);
        password=MD5.encrypt(password.substring(0,20));
        proxy.setPassword(password);
        baseMapper.insert(proxy);
        return Result.success().setMsg("注册成功").setData("注册的用户信息为",registerVo);
    }

    @Override
    public Result login(LoginVo loginVo) {
        String phone=loginVo.getPhone();
        String password=loginVo.getPassword();
        QueryWrapper<Proxy> proxyQueryWrapper=new QueryWrapper<>();
        proxyQueryWrapper.eq("phone",phone);
        Proxy proxy=baseMapper.selectOne(proxyQueryWrapper);
        if(!StringUtils.checkValNotNull(proxy)){
            return Result.fail().setMsg("账户不存在");
        }
        password=MD5.encrypt(password);
        password=MD5.encrypt(password.substring(0,20));
        //对passwor进行加密与获取的密码进行判断
        if(!proxy.getPassword().equals(password)){
            return Result.fail().setMsg("账户或密码错误");
        }
        String token= JwtUtils.getJwtToken(proxy.getId(),proxy.getName(),proxy.getRole());
        return Result.success().setMsg("登陆成功").setData("token",token);
    }

    @Override
    public Result getInfoByToken(String id) {
        Proxy proxy=baseMapper.selectById(id);
        InfoVo infoVo=new InfoVo();
        BeanUtils.copyProperties(proxy,infoVo);
        return Result.success().setMsg("根据token获取的信息").setData("infoVo",infoVo);
    }

    @Override
    public Result updateCardById(InfoVo infoVo) {
        String id=infoVo.getId();
        if(id==null){
            return Result.fail().setMsg("前端信息错误");
        }
        String password=infoVo.getPassword();
        System.out.println(password);
        if(password==null||StringUtils.isEmpty(password)){
            return Result.fail().setMsg("密码不能为空");
        }
        Proxy proxy=baseMapper.selectById(id);
        System.out.println(proxy.getPassword());
        if(!password.equals(proxy.getPassword())){
            password=MD5.encrypt(password);
            password=MD5.encrypt(password.substring(0,20));
            infoVo.setPassword(password);
        }
        BeanUtils.copyProperties(infoVo,proxy);
        baseMapper.updateById(proxy);
        return Result.success().setMsg("修改成功");
    }
    @Override
    public Result getProList() {
        List<Proxy> proxyList=new ArrayList<>();
        proxyList=baseMapper.selectList(null);
        Collections.sort(proxyList,new SchoolSort());
        return Result.success().setData("ProList",proxyList);
    }

    @Override
    public Result deleted(String id) {
        Proxy proxy=baseMapper.selectById(id);
        if(proxy==null){
            return Result.fail().setMsg("学校不存在");
        }
        QueryWrapper<Team> teamQueryWrapper=new QueryWrapper<>();
        teamQueryWrapper.eq("proxy_id",id);
        int count=teamService.count(teamQueryWrapper);
        if(count>0){
            if(teamService.remove(teamQueryWrapper)){
                if(baseMapper.deleteById(id)>0){
                    return Result.success().setMsg("删除成功");
                }
            }
        }
        if(baseMapper.deleteById(id)>0){
            return Result.success().setMsg("删除成功");
        }
        return Result.fail().setMsg("删除失败");
    }

    @Override
    public Result reset(String id) {
       Proxy proxy=baseMapper.selectById(id);
       if(proxy==null){
           return Result.fail().setMsg("该学校不存在");
       }
       String password="123456";
       password = MD5.encrypt(password);
       password=MD5.encrypt(password.substring(0,20));
       proxy.setPassword(password);
       baseMapper.updateById(proxy);
       return Result.success().setMsg("密码重置成功");
    }

    @Override
    public Result closeRoleAll() {

        List<Proxy> proxies=new ArrayList<>();
        proxies=baseMapper.selectList(null);
        for(Proxy proxy:proxies){
            proxy.setRole("0");
        }
        if(proxyService.updateBatchById(proxies)){
            return Result.success().setMsg("所有学校权限关闭成功");
        }
        return Result.fail().setMsg("所有学校权限关闭失败");
    }

    @Override
    public Result openRoleAll() {
        List<Proxy> proxies=new ArrayList<>();
        proxies=baseMapper.selectList(null);
        for(Proxy proxy:proxies){
            proxy.setRole("1");
        }
        if(proxyService.updateBatchById(proxies)){
            return Result.success().setMsg("所有学校权限打开成功");
        }
        return Result.fail().setMsg("所有学校权限打开失败");
    }

    @Override
    public Result closeRoleById(String id) {
        Proxy proxy=baseMapper.selectById(id);
        if(proxy==null){
            return Result.fail().setMsg("用户不存在");
        }
        proxy.setRole("0");
        baseMapper.updateById(proxy);
        return Result.success().setMsg("该学校权限关闭成功");
    }

    @Override
    public Result openRoleById(String id) {
        Proxy proxy=baseMapper.selectById(id);
        if(proxy==null){
            return Result.fail().setMsg("用户不存在");
        }
        proxy.setRole("1");
        baseMapper.updateById(proxy);
        return Result.success().setMsg("该学校权限打开成功");
    }
}
