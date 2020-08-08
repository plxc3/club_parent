package com.hmy.acl.feign;

import com.hmy.acl.vo.LoginVo;
import com.hmy.acl.vo.RegisterVo;
import com.plxcc.servicebase.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("service-dao")
public interface UserFeignService
{
    @PostMapping("/dao/user/login")
    public Result login(LoginVo loginVo);

    @PostMapping("/dao/user/register")
    public Result register(RegisterVo registerVo);

}
