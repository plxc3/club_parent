package com.plxcc.admin.service;

import java.util.Map;

/**
 * @PackgeName: com.plxcc.admin.service
 * @ClassName: MsmService
 * @Author: plxc
 * Date: 2020/8/16 16:10
 * project name: club_parent
 * @Version:
 * @Description:
 */
public interface MsmService {
    Boolean sendCode(Map<String, Object> param, String phone);
}
