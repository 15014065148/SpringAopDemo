package com.example.demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限验证
 */
@Component
@Aspect
public class AuthCheckAop {

    //定义切点
    @Pointcut("@annotation(com.example.demo1.annotation.AuthCheck)")
    public void pointcut(){}

    //增强
    @Around("pointcut()")
    public Object authcheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getParameter("token");
        if ( token==null||!token.equals("123456")){
            return "没有足够的权限！";
        }
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

}