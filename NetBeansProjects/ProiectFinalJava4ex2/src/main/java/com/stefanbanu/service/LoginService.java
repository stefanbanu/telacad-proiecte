/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stefanbanu.service;

import com.stefanbanu.dao.UserDao;
import com.stefanbanu.db.UsersDB;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author student
 */
@Service
public class LoginService {
    private UserDao userDao;
    
    private LoginService(){
        userDao = new UserDao();
    }
    
    private static final class SingletonHolder{
        private static final LoginService SINGLETON = new LoginService();
    }
    
    public static LoginService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public UsersDB login(String username, String password) {
       
            UsersDB user = userDao.findUserByUsername(username);
           
        
        return null;
    }
    
    public boolean register(String username, String password){
       
        return false;
    }
    
    public List<UsersDB> getAllOtherUsers(int userID){
        List<UsersDB> users = null;
      
        return users;
    }
}
