package com.hmy.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hmy
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    private String nickname;

    private String email;

    private String phone;

    private String password;

    @ApiModelProperty(value = "权限管理,0只能无法进入社团管理页面，1部分权限，2全部社团管理权限")
    private String role;

    private Boolean isDisable;

    private Date createTime;

    private Date modifiedTime;


}
