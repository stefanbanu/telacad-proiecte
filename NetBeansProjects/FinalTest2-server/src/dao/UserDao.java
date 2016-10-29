/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.UsersDB;

/**
 *
 * @author Stefan
 */
public class UserDao {
    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaUser(UsersDB uDb){
        em.persist(uDb);
    }
    
    public UsersDB findUserByName(String name){
        Query q = em.createNamedQuery("UsersDB.findByUsername", UsersDB.class);
        q.setParameter("username", name);     
        
        try {
            return (UsersDB) q.getSingleResult();
        } catch (Exception e) {
            // return Optional.empty();
            return null;
        }
    }
    
}
