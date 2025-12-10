package org.j2os.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Aspect
@Component

public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.j2os..*(..)) && !execution(* org.springdoc..*(..))")
    public void logBefore(JoinPoint joinPoint){
        logger.info("➡️ Before: " + joinPoint.getSignature()
                + " args: " + Arrays.toString(joinPoint.getArgs()));
    }

    // ====== 1) برای همه‌ی Controllerها ======
    @Before("execution(* org.j2os.api..*(..)) && !execution(* org.springdoc..*(..))")
    public void logController(JoinPoint joinPoint) {

        // 1. گرفتن Correlation ID از MDC یا ساختن
        String correlationId = MDC.get("correlationId");
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
            MDC.put("correlationId", correlationId);
        }

        logger.info("➡️ Controller Call: {} args={}",
                joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()));
    }

    // ====== 2) زمان اجرای Serviceها (همان کدی که داشتی) ======
    @Around("execution(* org.j2os.service..*(..)) && !execution(* org.springdoc..*(..))")
    public Object logServiceExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        String correlationId = MDC.get("correlationId");
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
            MDC.put("correlationId", correlationId);
        }

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            logger.info("⏱️ Execution Time: {} duration {} ms",
                    joinPoint.getSignature(),
                    duration);
        }
    }

    // ====== 3) پاک کردن MDC بعد از هر Request ======
    @After("execution(* org.j2os.api..*(..)) && !execution(* org.springdoc..*(..))")
    public void clearMdc() {
        MDC.clear();
    }
}