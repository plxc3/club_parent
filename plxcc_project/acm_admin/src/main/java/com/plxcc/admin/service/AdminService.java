package com.plxcc.admin.service;

import com.plxcc.admin.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
public interface AdminService extends IService<Admin> {

    Result login(Admin admin);

    Result changePassword(Admin admin);
}
