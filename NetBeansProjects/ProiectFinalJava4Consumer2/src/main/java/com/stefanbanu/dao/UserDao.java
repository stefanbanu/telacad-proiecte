/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.dao;

import com.stefanbanu.db.UsersDB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stefan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public void adaugaUser(UsersDB u) {
        em.persist(u);
      //  em.flush();
    }
}
