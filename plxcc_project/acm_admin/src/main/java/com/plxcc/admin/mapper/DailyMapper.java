package com.plxcc.admin.mapper;

import com.plxcc.admin.entity.Daily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 网站统计日数据 Mapper 接口
 * </p>
 *
 * @author plxcc
 * @since 2020-08-21
 */
public interface DailyMapper extends BaseMapper<Daily> {

    //查询某一天的注册人数
    Integer createRegister(String day);
}
