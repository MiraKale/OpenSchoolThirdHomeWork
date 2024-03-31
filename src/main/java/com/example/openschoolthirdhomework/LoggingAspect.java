package com.example.openschoolthirdhomework;

import com.example.openschoolthirdhomework.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.openschoolthirdhomework.service.OrderService.*(..)) ||" +
            " execution(* com.example.openschoolthirdhomework.service.UserService.*(..))")
    public void callAtMyServiceMethods() { }

    @Before("callAtMyServiceMethods()")
    public void beforeCallLog(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before " + jp + ", args=[" + args + "]");
    }

    @After("callAtMyServiceMethods()")
    public void afterCallLog(JoinPoint jp) {
        log.info("after " + jp.toString());
    }
}
