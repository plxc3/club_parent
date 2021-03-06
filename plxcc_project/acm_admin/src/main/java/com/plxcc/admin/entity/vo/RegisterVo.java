package com.plxcc.admin.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.admin.entity.vo
 * @ClassName: RegisterVo
 * @Author: plxc
 * Date: 2020/8/16 16:57
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
public class RegisterVo {


    @ApiModelProperty(value = "短信注册码")
    private String code;

    @ApiModelProperty(value = "该表的主键")
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
    private String tfn;
}
