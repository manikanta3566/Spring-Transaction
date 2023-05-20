package com.practice.transaction.aop;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DataSourceAspect {


    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("data source "+proceedingJoinPoint.getSignature());
        Object proceed = proceedingJoinPoint.proceed();
        Connection con = (Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(),
                new Class[]{Connection.class}, new ConnectionInvocationHandler((Connection) proceed));
        return con;
    }
}
