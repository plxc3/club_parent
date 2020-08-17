package com.plxcc.admin.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.admin.entity.vo
 * @ClassName: AdminListVo
 * @Author: plxc
 * Date: 2020/8/17 15:54
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
public class AdminListVo {

    @ApiModelProperty(value = "该表的主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @ApiModelProperty(value = "直接注入Proxy的用户id")
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

//    @ApiModelProperty(value = "所属学校ID")
//    @TableField("ofUniID")
//    private String ofUniID;

    @ApiModelProperty(value = "队伍状态码")
    private String state;


    @TableField("coachTsize")
    private String coachTsize;

    @ApiModelProperty(value = "学校名字")
    @TableField("uniName")
    private String uniName;


    @ApiModelProperty(value = "电话")
    private String phone;


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

}
