package org.j2os.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.j2os..*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("➡️ Before: " + joinPoint.getSignature()
                + " args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* org.j2os.service.. *(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println("⏱️ Execution Time: " + joinPoint.getSignature() + " duration: " + duration + " ms");
        }
    }
}