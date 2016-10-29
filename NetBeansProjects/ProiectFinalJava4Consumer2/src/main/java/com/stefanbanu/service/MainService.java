/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.service;

import com.stefanbanu.dao.UserDao;
import com.stefanbanu.db.UsersDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stefan
 */
@Service
public class MainService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void adaugaUser(String username) {
        UsersDB u = new UsersDB();
        u.setUser(username);
        userDao.adaugaUser(u);
    }
}
