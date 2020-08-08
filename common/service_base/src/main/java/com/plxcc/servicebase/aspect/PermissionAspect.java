package com.plxcc.servicebase.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionAspect
{

//    @Pointcut(value = "@annotation(Permission)")
//    public void pointcut(Permission permission) {
//
//    }
//
//    @Before(value = "pointcut(permission)", argNames = "joinPoint,permission")
//    public Object doBefore(ProceedingJoinPoint joinPoint, Permission permission) throws Throwable
//    {
//        int minLevel = permission.value();
//        if (minLevel == 0){
//            return joinPoint.proceed();
//        }
//        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attribute != null;
//        HttpServletRequest request = attribute.getRequest();
//        Cookie[] cookies = request.getCookies();
//        if (cookies == null){
//            return R.error(403,"没有权限");
//        }
//        if (jwtService.verity(cookies,minLevel)){
//            return joinPoint.proceed();
//        }
//        return R.error(403,"没有权限");
//    }
}
