package com.plxcc.admin.service;

import com.plxcc.admin.entity.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plxcc.admin.entity.vo.ItemVo;
import com.plxcc.servicebase.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author plxcc
 * @since 2020-08-17
 */
public interface TeamService extends IService<Team> {

    Result addIteam(ItemVo itemVo);

    Result getListByPd(String id);

    Result updateTeamById(ItemVo itemVo);

    Result deletdByTeamId(String id);
}
