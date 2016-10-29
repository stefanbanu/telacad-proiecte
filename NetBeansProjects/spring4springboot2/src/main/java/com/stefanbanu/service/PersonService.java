/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.service;

import com.stefanbanu.main.MainClass;
import com.stefanbanu.model.Person;
import java.util.Hashtable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stefan
 */
@Service
public class PersonService {
     Hashtable<String, Person> persons = new Hashtable<String, Person>();

    public PersonService() {
        System.out.println("================ service");
        Person p = new Person();
        p.setId("1");
        p.setName("Stefan");
        
        persons.put("1", p);
        
        p = new Person();
        p.setId("2");
        p.setName("Steve");
        
        persons.put("2", p);
    }
     public Person getPerson(String id){
         if(persons.containsKey(id)){
             return persons.get(id);
         }else {
             return null;
         }
     }
     public Hashtable<String, Person> getAll(){
         return persons;
     }
     
     public void addPerson(String nume){
  
         System.out.println("addd person ====================" + nume);
         Person p = new Person();
         p.setId("3");
         p.setName(nume);
         persons.put("3", p);
         System.out.println(persons);
         
        
     }
     
}
