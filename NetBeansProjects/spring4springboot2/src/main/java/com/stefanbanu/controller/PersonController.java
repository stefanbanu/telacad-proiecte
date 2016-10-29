/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.controller;

import com.stefanbanu.model.Person;
import com.stefanbanu.model.Person;
import com.stefanbanu.service.PersonService;
import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Stefan
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService ps;
    
    /**
     *
     * @return
     */
    @RequestMapping("/all")
    public Hashtable<String, Person> getAll(){
        return ps.getAll();
    }
    @RequestMapping("{id}")
    public Person getPerson(@PathVariable("id") String id){
        return ps.getPerson(id);
    }
    
}
