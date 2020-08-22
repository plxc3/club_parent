package com.plxcc.admin.service;

import com.plxcc.admin.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.admin.entity.vo.DateVo;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-21
 */
public interface DailyService extends IService<Daily> {

    Result createRegister(String day);

    Result getShowData(DateVo dateVo);

    Boolean createLogin(String day);
}
