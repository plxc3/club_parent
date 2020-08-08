package com.hmy.acl.vo;

import lombok.Data;

/**
 * @PackgeName: com.plxcc.center.entity.vo
 * @ClassName: RegisterVo
 * @Author: plxc
 * Date: 2020/8/8 6:15
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
public class RegisterVo {
    private String email;

    private String phone;

    private String password;

    private String code;
}
