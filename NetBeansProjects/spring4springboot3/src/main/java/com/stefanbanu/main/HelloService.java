/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.main;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Stefan
 */
@RestController
public class HelloService {
    
    ArrayList<User> users = new ArrayList<User>();
    
    @RequestMapping("/user")
    public User getUser(){
        User u = new User();
        u.setNume("ion");
        u.setParola("11");
        return u;
    }
}
