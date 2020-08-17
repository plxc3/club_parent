package com.plxcc.admin.service;

import com.plxcc.admin.entity.Proxy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.admin.entity.vo.InfoVo;
import com.plxcc.admin.entity.vo.LoginVo;
import com.plxcc.admin.entity.vo.RegisterVo;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-16
 */
public interface ProxyService extends IService<Proxy> {

    Boolean getByPhone(String phone);

    Result register(RegisterVo registerVo);

    Result login(LoginVo loginVo);

    Result getInfoByToken(String id);

    Result updateCardById(InfoVo infoVo);

    Result getProList();
}
