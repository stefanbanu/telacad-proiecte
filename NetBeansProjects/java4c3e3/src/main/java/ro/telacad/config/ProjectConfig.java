/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ro.telacad.aspect.MyAspect;
import ro.telacad.service.MyService;

/**
 *
 * @author student
 */
@Configuration
@EnableAspectJAutoProxy
public class ProjectConfig {
    
    @Bean
    public MyService myService(){
        return new MyService();
    }
    
    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }
}
