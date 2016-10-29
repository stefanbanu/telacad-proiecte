/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller.dao;

import java.util.List;
import model.UsersDB;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Stefan
 */
public class UsersDao {
    private EntityManager em;

    public UsersDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaUser(UsersDB user){
        em.persist(user);
    }
    
    public UsersDB findUser(String username){
        System.out.println("find user");
        Query q = em.createNamedQuery("UsersDB.findByUsername", UsersDB.class);
        q.setParameter("username", username);
        
        try {
            return (UsersDB) q.getSingleResult();
        } catch (Exception e) {
            // return Optional.empty();
            return null;
        }
    }
    
      public List<UsersDB> getUseriByUser(String user){
        Query q = em.createNamedQuery("UsersDB.findByUsername", UsersDB.class);
        q.setParameter("username", user);
        List<UsersDB> useri = (List<UsersDB>) q.getResultList();
        return useri;
    }
}
