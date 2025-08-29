package com.wipro.knr.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.wipro.knr.controller.*.*(..)) || execution(* com.wipro.knr.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering method: " + methodName); 
    }

    @AfterReturning(pointcut = "execution(* com.wipro.knr.controller.*.*(..)) || execution(* com.wipro.knr.service.*.*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exiting method: " + methodName + " with result: " + result);
    }
}
