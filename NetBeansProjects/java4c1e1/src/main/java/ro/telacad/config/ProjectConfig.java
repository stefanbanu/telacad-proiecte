/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ro.telacad.beans.Punct;

/**
 *
 * @author student
 */
@Configuration
public class ProjectConfig {
    
    @Bean
    @Primary
    public Punct punct1(){
        Punct p1 = new Punct();
        p1.setX(10);
        p1.setY(20);
        return p1;
    }
    
    @Bean
    public Punct punct2(){
        Punct p1 = new Punct();
        p1.setX(30);
        p1.setY(40);
        return p1;
    }
}
