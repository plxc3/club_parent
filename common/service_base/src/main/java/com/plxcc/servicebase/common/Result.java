package com.plxcc.servicebase.common;

import com.plxcc.servicebase.utils.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackgeName: com.plxcc.servicebase.config.common
 * @ClassName: Result
 * @Author: plxc
 * Date: 2020/7/5 16:49
 * project name: edu_parent
 * @Version:
 * @Description:统一结果返回类
 */
@Data
public class Result <T> {
    /**
     * 构造方法私有化
     */
    private Result(){};

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private Map<String,T> data=new HashMap<String,T>();

    /**
     * 静态方法
     */

    public static Result success(){
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setSuccess(true);
        return result;
    }

    public static Result fail(){
        Result result=new Result();
        result.setCode(ResultCode.ERROR);
        result.setSuccess(false);
        return result;
    }

    public Result setrCode(Integer code){
        this.code=code;
        return this;
    }

    public Result setMsg(String msg){
        this.msg=msg;
        return this;
    }

    public Result setData(String key,T vaule){
        this.data.put(key, vaule);
        return this;
    }

    public Result setData(Map<String,T>data){
        this.data=data;
        return this;
    }

}
