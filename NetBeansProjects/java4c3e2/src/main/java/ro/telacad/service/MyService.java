/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 *
 * @author student
 */
@Service
@Lazy
public class MyService {
    
    @PostConstruct
    public void init(){
        System.out.println("A fost creata instanta!");
    }
    
    public void exemplu(){
        System.out.println("Exemplu");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("A fost eliberata instanta din context!");
    }
}
