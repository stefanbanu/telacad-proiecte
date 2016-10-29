/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.main;

import com.stefanbanu.config.ProjectConfig;
import com.stefanbanu.db.UsersDB;
import com.stefanbanu.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
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
        
        MainService service = context.getBean(MainService.class);
        
        /*  RestTemplate rest = new RestTemplate();
        
        String url = "http://localhost:8080/rest/user";
        Person p = rest.getForObject(url, Person.class);
        System.out.println(p.getNume() + " " + p.getParola());*/
        
        service.adaugaUser("Marcu");
    }
}
