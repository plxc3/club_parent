package com.plxcc.admin.controller;


import com.plxcc.admin.entity.vo.InfoVo;
import com.plxcc.admin.entity.vo.LoginVo;
import com.plxcc.admin.entity.vo.RegisterVo;
import com.plxcc.admin.service.ProxyService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.config.PermissionVerify;
import com.plxcc.servicebase.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/admin/proxy")
public class ProxyController {
    @Autowired
    private ProxyService proxyService;

    /**
     * 根据手机号查询用户
     */
    @ApiOperation(tags = {"user"},value = "根据手机号查询用户是否存在")
    @GetMapping("/exitByPhone/{phone}")
    public Boolean getByPhone(@PathVariable String phone){
        return proxyService.getByPhone(phone);
    }
    /**
     * Register
     */
    @ApiOperation(tags = {"user"},value = "注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterVo registerVo){
        return proxyService.register(registerVo);
    }

    /**
     * 登陆接口
     */
    @ApiOperation(tags = {"user"},value = "登陆接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo){
        return proxyService.login(loginVo);
    }
    /**
     * 根据token获取用户信息
     */
    @ApiOperation(tags = {"user"},value = "通过token获取信息的接口")
    @GetMapping("/getInfoBytoken")
    public Result getInfoByToken(HttpServletRequest request){
        //调用JWT工具类的方法，根据request对象获取头信息，返回用户id
        if(!JwtUtils.checkToken(request)){
            return Result.fail().setMsg("无效的token");
        }
        try {
            String id=JwtUtils.getMemberIdByJwtToken(request);
            return  proxyService.getInfoByToken(id);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    /**
     * 更新信息Card user
     */
    @ApiOperation(tags = {"user"},value = "更新card")
    @PostMapping("/update")
    public Result updateCardById(@RequestBody InfoVo infoVo){
        return proxyService.updateCardById(infoVo);
    }
    /**
     * 返回列表
     */
    @ApiOperation(tags = {"user"},value = "返回列表")
    @GetMapping("/getProList")
    public Result getProList(){
        return proxyService.getProList();
    }
    /**
     * 删除学校
     */
    @ApiOperation(tags = {"user"},value = "删除")
    @GetMapping("/deleted/{id}")
    public Result deletedProxy(@PathVariable String id){
        return proxyService.deleted(id);
    }
    /**
     * 重置当前学校密码
     */
    @ApiOperation(tags = {"user"},value = "重置密码")
    @GetMapping("/reset/{id}")
    public Result reset(@PathVariable String id){
     return    proxyService.reset(id);
    }

    /**
     * 关闭权限ALL
     */
    @ApiOperation(tags = {"user"},value = "关闭权限ALL")
    @GetMapping("/closeRoleAll")
    public Result closeRoleAll(){
       return proxyService.closeRoleAll();
    }
    /**
     * 打开权限ALL
     */
    @ApiOperation(tags = {"user"},value = "打开权限ALL")
    @GetMapping("/openRoleAll")
    public Result openRoleAll(){
        return proxyService.openRoleAll();
    }
    /**
     * 根据id关闭权限
     */
    @ApiOperation(tags = {"user"},value = "根据id关闭权限")
    @GetMapping("/closeRoleById/{id}")
    public Result closeRoleById(@PathVariable String id){
        return proxyService.closeRoleById(id);
    }
    /**
     * 根据id打开权限
     */
    @ApiOperation(tags = {"user"},value = "根据id打开权限")
    @GetMapping("/openRoleById/{id}")
    public Result openRoleById(@PathVariable String id){
        return proxyService.openRoleById(id);
    }

}

