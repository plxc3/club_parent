package com.plxcc.center.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BannerList对象", description="")
public class BannerList implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String title;

    private String imageUrl;

    private String linkUrl;

    private String isDeleted;

    @TableField(fill= FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;


}
