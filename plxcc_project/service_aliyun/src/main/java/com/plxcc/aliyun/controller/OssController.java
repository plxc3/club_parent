package com.plxcc.aliyun.controller;

import com.plxcc.aliyun.service.OssService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PackgeName: com.plxcc.aliyun.controller
 * @ClassName: OssController
 * @Author: plxc
 * Date: 2020/8/7 22:40
 * project name: club_parent
 * @Version:
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/oss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    //上传头像方法
    @PostMapping("/")
    @ApiOperation(tags = {"oss"},value = "头像上传接口")
    public Result uploadOssFile(MultipartFile file) throws Exception {
        //获取上传文件 MultipartFile
        //返回上传的oss的路径

        String url=ossService.uploadAvatar(file);

        return Result.success()
                .setData("url",url)
                .setMsg("头像url");
    }

}
