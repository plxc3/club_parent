package com.plxcc.servicebase.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.plxcc.servicebase.utils
 * @ClassName: ZTException
 * @Author: plxc
 * Date: 2020/7/12 15:42
 * project name: edu_parent
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZTException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;

}