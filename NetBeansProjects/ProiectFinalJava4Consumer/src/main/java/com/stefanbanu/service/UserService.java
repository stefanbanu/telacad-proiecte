/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stefanbanu.dao.UserDao;
import com.stefanbanu.db.UsersDB;

/**
 *
 * @author student
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void adaugaPersoana(UsersDB u) {

        userDao.adaugaPersoana(u);
    }
}
