/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author student
 */
@Aspect
@Component
public class MyAspect {
    
    @Around("execution(** ro.telacad.service.MyService.myUseCase(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("BAU");
        pjp.proceed();
    }
}
