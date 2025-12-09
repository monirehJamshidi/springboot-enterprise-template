package org.j2os.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component

public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.j2os..*(..))")
    public void logBefore(JoinPoint joinPoint){
        logger.info("➡️ Before: " + joinPoint.getSignature()
                + " args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* org.j2os.service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            logger.info("⏱️ Execution Time: " + joinPoint.getSignature() + " duration: " + duration + " ms");
        }
    }
}