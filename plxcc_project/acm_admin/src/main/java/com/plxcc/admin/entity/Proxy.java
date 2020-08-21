package com.plxcc.admin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Proxy")
@ApiModel(value="Proxy对象", description="")
public class Proxy implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "该表的主键")
      @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "学校名字")
    @TableField("uniName")
    private String uniName;

    @ApiModelProperty(value = "邮寄地址")
    private String address;

    @ApiModelProperty(value = "学校英文名字")
    @TableField("uniEngName")
    private String uniEngName;

    @ApiModelProperty(value = "老师名字")
    private String name;

    @ApiModelProperty(value = "发票抬头")
    private String invoice;

    @ApiModelProperty(value = "税号")
    @TableField("TFN")
    private String tfn;

    private String role;

    @ApiModelProperty(value = "逻辑删除，0未删除，1删除，默认0")
    @TableLogic
    private Integer isDeletd;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;


}
