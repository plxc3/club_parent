package com.plxcc.aliyun.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @PackgeName: com.plxcc.aliyun.feign
 * @ClassName: UserFeign
 * @Author: plxc
 * Date: 2020/8/10 5:27
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Component
@FeignClient(name = "service-center-7001")
public interface UserFeign {

    /**
     * 定义要调用的方法路径
     * @param phone
     * @return
     */
    @GetMapping("/center/user/exitByPhone/{phone}")
    public Boolean getByPhone(@PathVariable("phone") String phone);

    @GetMapping("/center/user/exitByEmail/{email}")
    public Boolean getByEmail(@PathVariable("email") String email);
}
