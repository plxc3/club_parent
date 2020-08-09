package com.plxcc.servicebase.config;

import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PermissionAspect
{

    @Pointcut(value = "@annotation(permissionVerify)")
    public void pointcut(PermissionVerify permissionVerify) {

    }

    @Around(value = "pointcut(permissionVerify)", argNames = "joinPoint,permissionVerify")
    public Object doAround( ProceedingJoinPoint joinPoint,PermissionVerify permissionVerify) throws Throwable
    {
        int minLevel = permissionVerify.value();
        if (minLevel == 0){
            return joinPoint.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String role = JwtUtils.getRoleByToken(request);
        if (role != null && !role.isEmpty()){
            if (Integer.parseInt(role) >= minLevel){
                return joinPoint.proceed();
            }
            return Result.fail().setMsg("权限不足");
        }
        return Result.fail().setMsg("没有登录");
    }
}
