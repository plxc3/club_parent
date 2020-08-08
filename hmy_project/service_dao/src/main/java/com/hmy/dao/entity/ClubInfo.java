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
@ApiModel(value="ClubInfo对象", description="")
public class ClubInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "club_id", type = IdType.ID_WORKER_STR)
    private String clubId;

    private String introduce;

    private String description;

    private String notice;

    private String isDeleted;

    private Date createTime;


}
