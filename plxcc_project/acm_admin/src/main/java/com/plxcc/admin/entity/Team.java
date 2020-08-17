package com.plxcc.admin.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;

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
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Team对象", description="")
public class Team implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "该表的主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "直接注入Proxy的用户id")
    @TableField("proxy_id")
    private String proxyId;


    @ApiModelProperty(value = "队名")
    @TableField("teamName")
    private String teamName;

    @ApiModelProperty(value = "队伍英文名")
    @TableField("teamEngName")
    private String teamEngName;

    @ApiModelProperty(value = "队员1名字")
    private String name1;

    @ApiModelProperty(value = "队员1名字拼音")
    private String pinyin1;

    @ApiModelProperty(value = "队员1 性别 1 男 2 女")
    private String sex1;


    @TableField("tsize1")
    private String tsize1;

    @ApiModelProperty(value = "队员2的名字")
    private String name2;

    @ApiModelProperty(value = "队员1的名字拼音")
    private String pinyin2;

    @ApiModelProperty(value = "队员的2性别")
    private String sex2;

    @TableField("tsize2")
    private String tsize2;

    @ApiModelProperty(value = "队员3的名字")
    private String name3;

    @ApiModelProperty(value = "队员3的拼音")
    private String pinyin3;

    @ApiModelProperty(value = "队员3的性别")
    private String sex3;

    @TableField("tsize3")
    private String tsize3;

    @ApiModelProperty(value = "教练名字")
    @TableField("coachName")
    private String coachName;

    @ApiModelProperty(value = "教练名字拼音")
    @TableField("coachPinyin")
    private String coachPinyin;

    @ApiModelProperty(value = "教练 性别 1 男 2 女")
    @TableField("coachSex")
    private String coachSex;

    @TableField("coachTsize")
    private String coachTsize;

//    @ApiModelProperty(value = "所属学校ID")
//    @TableField("ofUniID")
//    private String ofUniID;

    @ApiModelProperty(value = "队伍状态码")
    private String state;

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
