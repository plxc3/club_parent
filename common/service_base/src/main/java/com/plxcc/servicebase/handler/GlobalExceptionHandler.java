package com.plxcc.servicebase.handler;

import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.ZTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @PackgeName: com.plxcc.servicebase.handler
 * @ClassName: GlobalExceptionHandler
 * @Author: plxc
 * Date: 2020/7/6 15:28
 * project name: edu_parent
 * @Version:
 * @Description:全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail()
                .setMsg("执行了全局异常处理")
                .setData("error",e.getMessage());
    }

    //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        log.error((e.getMessage()));
        e.printStackTrace();
        return Result.fail()
                .setMsg("执行了ArithmeticException异常处理")
                .setData("error",e.getMessage());
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(ZTException.class)
    @ResponseBody
    public Result error(ZTException e){
        e.printStackTrace();
        return Result.fail().setMsg(e.getMsg()+e.getCode());
    }
}

