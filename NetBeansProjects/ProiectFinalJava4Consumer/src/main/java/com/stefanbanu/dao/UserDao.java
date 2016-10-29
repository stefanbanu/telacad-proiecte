/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.stefanbanu.db.UsersDB;

/**
 *
 * @author student
 */

@Repository
public class UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public void adaugaPersoana(UsersDB u){
        em.persist(u);
        em.flush();
    }
}
