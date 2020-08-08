package com.hmy.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="ClubMembers对象", description="")
public class ClubMembers implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "club_id", type = IdType.ID_WORKER_STR)
    private String clubId;

    private String userId;

    private String departmentId;

    private Date createTime;

    private Date modifiedTime;

    private Integer isDeleted;


}
