package com.example.openschoolthirdhomework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.openschoolthirdhomework.service.OrderService.*(..)) ||" +
            " execution(* com.example.openschoolthirdhomework.service.UserService.*(..))")
    public void callAtMyServiceMethods() {
    }


    @Pointcut("execution(* com.example.openschoolthirdhomework.service.OrderService.findAll(..)) ||" +
            " execution(* com.example.openschoolthirdhomework.service.UserService.findAll(..))")
    public void findAllMethods() {
    }

    @Before("callAtMyServiceMethods()")
    public void beforeCallLog(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before {}, args=[ {} ]", jp, args);
    }

    @After("callAtMyServiceMethods()")
    public void afterCallLog(JoinPoint jp) {
        log.info("after {}", jp);
    }

    @Around("findAllMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info( "{} выполнен за {} мс",joinPoint.getSignature(),executionTime);
        return proceed;
    }
}
