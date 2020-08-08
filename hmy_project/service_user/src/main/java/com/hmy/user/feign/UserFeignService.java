package com.hmy.user.feign;

import com.hmy.user.entity.User;
import com.hmy.user.entity.UserProfile;
import com.plxcc.servicebase.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("service-dao")
public interface UserFeignService
{
    @GetMapping("/dao/user/getUserById")
    Result<User> getUserById(@RequestParam String id);

    @GetMapping("/dao/user/getUserPage")
    Result userList(@RequestParam Map<String, Object> params);

    @GetMapping("/dao/user/getById")
    Result getById(@RequestParam String id);

    @GetMapping("/dao/user/update")
    Result update(UserProfile userProfile);
}
