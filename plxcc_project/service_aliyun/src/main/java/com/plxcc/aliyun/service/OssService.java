package com.plxcc.aliyun.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @PackgeName: com.plxcc.aliyun.service
 * @ClassName: OssService
 * @Author: plxc
 * Date: 2020/8/7 22:42
 * project name: club_parent
 * @Version:
 * @Description:
 */
public interface OssService {
    String uploadAvatar(MultipartFile file);
}
