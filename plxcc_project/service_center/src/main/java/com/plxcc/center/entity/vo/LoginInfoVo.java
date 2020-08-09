package com.plxcc.center.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.center.entity.vo
 * @ClassName: LoginInfoVo
 * @Author: plxc
 * Date: 2020/8/8 6:28
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
public class LoginInfoVo {

    private String userId;

    @ApiModelProperty(value = "头像")
    private String avatar;

}
