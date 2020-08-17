package com.plxcc.admin.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.admin.entity.vo
 * @ClassName: LoginVo
 * @Author: plxc
 * Date: 2020/8/16 17:27
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
public class LoginVo {

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

}
