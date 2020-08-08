package com.hmy.user.feign;

import com.hmy.user.entity.UserProfile;
import com.plxcc.servicebase.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("service-dao")
public interface UserProfileFeignService
{
    @GetMapping("/dao/user-profile/getById")
    Result getById(@RequestParam String id);

    @GetMapping("/dao/user-profile/update")
    Result update(UserProfile userProfile);

    @GetMapping("/dao/user-profile/list")
    Result list(@RequestParam Map<String,Object> params);

    @PostMapping("/dao/user-profile/insert")
    Result insert(@RequestBody UserProfile profile);
}
