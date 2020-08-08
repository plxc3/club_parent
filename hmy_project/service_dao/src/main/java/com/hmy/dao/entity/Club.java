package com.hmy.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @author hmy
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Club对象", description="")
public class Club implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "社团id")
      @TableId(value = "club_id", type = IdType.ID_WORKER_STR)
    private String clubId;

    @ApiModelProperty(value = "社团名字")
    private String clubName;

    @ApiModelProperty(value = "创建人")
    private String founder;

    @ApiModelProperty(value = "社团封面")
    private String clubCover;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "逻辑删除1（true）已删除  0（false）未删除 ")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;


}
