package com.practice.transaction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Pointcut("within(com.practice.transaction.service.*)")
    public void logerPointcut(){

    }

//    @Before("logerPointcut()")
//    public void logBefore(){
//        System.out.println("before service method call");
//    }
//
//    @After("logerPointcut()")
//    public void logAfter(){
//        System.out.println("after service method call");
//    }

    @Around("logerPointcut()")
    public void logAfterBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("method start -->"+proceedingJoinPoint.getSignature().getName());
        proceedingJoinPoint.proceed();
        System.out.println("method completed -->"+proceedingJoinPoint.getSignature().getName());
    }
}
