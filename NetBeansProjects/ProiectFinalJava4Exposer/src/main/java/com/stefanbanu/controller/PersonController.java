/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.controller;

import com.stefanbanu.model.Person;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Stefan
 */
@RestController
@RequestMapping("/rest")
public class PersonController {
    
   
    @RequestMapping("/user")
    public Person getPerson(@ModelAttribute Person p){
        /* Person u = new Person();
        u.setNume("gigel");
        u.setParola("12345");*/
        
        System.out.println(p.getNume() + " " + p.getParola());
   
        return p;
    }
}
