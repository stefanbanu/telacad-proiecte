/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.dao;

import com.stefanbanu.model.UserDB;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    /* @Autowired
    private JdbcTemplate jdbcTemplate;*/
    
    @PersistenceContext
    private EntityManager em;

    public void addUser(UserDB user) {
        /* String sql = "INSERT into users VALUES(NULL,?,?)";
        jdbcTemplate.update(sql, user.getNume(), user.getParola());*/
        System.out.println("userDao persist");
        em.persist(user);
       // em.flush();
    }

    public void loginUser(UserDB user) {
        
     //   System.out.println(getUsernameById(user.getId()));
    }

    /*   public String getUsernameById(long id) {
    String sql = "select user from users where id = ?";
    return jdbcTemplate.queryForObject(sql,
    new Object[]{id}, String.class);
    }*/
}
