package com.plxcc.aliyun.service;

import java.util.Map;

/**
 * @PackgeName: com.plxcc.aliyun.service
 * @ClassName: MsmService
 * @Author: plxc
 * Date: 2020/8/7 22:55
 * project name: club_parent
 * @Version:
 * @Description:
 */
public interface MsmService {
    Boolean sendCode(Map<String, Object> param, String phone);

    void sendEmail(String email,String code);
}
