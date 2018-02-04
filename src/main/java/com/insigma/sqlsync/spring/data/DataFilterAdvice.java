package com.insigma.sqlsync.spring.data;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

@Component
@Aspect
public class DataFilterAdvice {

    @PersistenceContext
    private EntityManager entityManager;

    @Around("@annotation(com.insigma.sqlsync.anntation.EnableFilter)")
    public void doProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] obj = joinPoint.getArgs();
        System.out.println(Arrays.toString(obj));
    }
}
