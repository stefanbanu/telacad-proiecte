/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author student
 */
@Aspect
public class MyAspect {
    
//    @Pointcut("execution(** ro.telacad.service.MyService.myUseCase(..))")
//    public void myPointcut(){}
    
    @Before("execution(** ro.telacad.service.MyService.myUseCase(..))")
    public void before(){
        System.out.println("BEFORE EXECUTION");
    }
    
    @After("execution(** ro.telacad.service.MyService.myUseCase(..))")
    public void after(){
        System.out.println("AFTER EXECUTION");
    }
    
    @AfterReturning("execution(** ro.telacad.service.MyService.myUseCase(..))")
    public void afterReturning(){
        System.out.println("AFTER RETURNING");
    }
    
    @AfterThrowing("execution(** ro.telacad.service.MyService.myUseCase(..))")
    public void afterThrowing(){
        System.out.println("AFTER THROWING");
    }
    
}
