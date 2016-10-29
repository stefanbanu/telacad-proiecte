/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.main;

import com.stefanbanu.config.ProjectConfig;
import com.stefanbanu.db.UsersDB;
import com.stefanbanu.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Stefan
 */
public class Main {
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(
                        ProjectConfig.class);
        
        UserService service = context.getBean(UserService.class);
        
        RestTemplate rest = new RestTemplate();
        
        String url = "http://localhost:8080/rest/user";
        Person p = rest.getForObject(url, Person.class);
        System.out.println(p.getNume() + " " + p.getParola());
        
        UsersDB u = new UsersDB();
        u.setNume(p.getNume());
        u.setParola(p.getParola());
        
        service.adaugaPersoana(u);
        
        
    }
}
