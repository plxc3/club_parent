package com.plxcc.center.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserProfile对象", description="")
public class UserProfile implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户档案id（用户注册后就直接注入用户的id）")
      @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    @ApiModelProperty(value = "社团id")
    private String clubId;

    @ApiModelProperty(value = "性别  1男 0女")
    private Integer sex;

    @ApiModelProperty(value = "社团成员姓名")
    private String name;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "学号")
    private Integer sno;

    @ApiModelProperty(value = "系")
    private String dept;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "状态码，0默认状态代表审核未通过，1代表审核通过")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除")
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;


}
