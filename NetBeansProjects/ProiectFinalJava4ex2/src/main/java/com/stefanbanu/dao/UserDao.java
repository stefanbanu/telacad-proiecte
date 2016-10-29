/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.dao;

import com.stefanbanu.db.UsersDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author student
 */
@Repository
public class UserDao {

    public UsersDB findUserByUsername(String username){
       
        return null;
    }
    
    public void adaugaUser(UsersDB user){
       
    }
    
    public List<UsersDB> getAllOtherUsers(int userID) throws SQLException{
       
        List<UsersDB> users = new ArrayList<>();
       
        return users;
    }
}
