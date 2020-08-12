package com.plxcc.center.controller;


import com.plxcc.center.entity.UserProfile;
import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.center.service.UserProfileService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/center/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService profileService;

    @GetMapping("/test/{id}")
    @ApiOperation(tags = {"userProfile"},value = "test")
    public Result test(@PathVariable String id){
        UserProfile userProfil=profileService.getById(id);
        return Result.success().setData("data",userProfil);

    }

    @PostMapping("/updateAvatar")
    public Result updateAvatar(@RequestBody LoginInfoVo avatarvo){
        return profileService.updateAvatar(avatarvo);
    }

}

