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
 * @since 2020-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Hotel对象", description="")
public class Hotel implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String hotelName;

    private String hotelAddress;

    private String distance;

    private String singlePrice;

    private String standardPrice;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean idDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;


}
