/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.telacad.beans.Cerc;
import ro.telacad.beans.Punct;

/**
 *
 * @author student
 */
@Configuration
public class ProjectConfig {
    
    @Bean
    public Punct punct1(){
        Punct p = new Punct();
        p.setX(10);
        p.setY(60);
        return p;
    }
    
    @Bean
    @Autowired
    public Cerc cerc1(Punct punct){
        Cerc cerc1 = new Cerc();
        cerc1.setCentru(punct);
        cerc1.setRaza(10);
        return cerc1;
    }
}
