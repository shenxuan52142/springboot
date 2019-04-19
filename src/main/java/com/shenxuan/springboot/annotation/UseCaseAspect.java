package com.shenxuan.springboot.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UseCaseAspect {
    @Around("@annotation(useCase)")
    public Object BeforeUseCase(ProceedingJoinPoint proceedingJoinPoint,UseCase useCase)throws Throwable{
        System.out.println("sssssss");
           Object o=null;
        return o;
    }
}
