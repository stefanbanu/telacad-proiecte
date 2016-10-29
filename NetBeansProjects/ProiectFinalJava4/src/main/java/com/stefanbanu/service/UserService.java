/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.service;

import com.stefanbanu.dao.UserDao;
import com.stefanbanu.model.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stefan
 */
@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void registerUser(UserDB u){
       
        userDao.addUser(u);
    }
    
     public void loginUser(UserDB u){
         System.out.println("from service");
        userDao.loginUser(u);
    }
    
}
