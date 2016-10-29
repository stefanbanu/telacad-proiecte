/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.UsersDB;

public class UsersDao {

    private EntityManager em;

    public UsersDao(EntityManager em) {
        this.em = em;
    }

    public List<UsersDB> getUsersByName(UsersDB u) {
        Query q = em.createNamedQuery("UsersDB.findByUsername");
        q.setParameter("username", u.getUsername());
        List<UsersDB> useri = q.getResultList();
        return useri;
    }

    public void addUser(UsersDB u) {
        
        
       em.persist(u);
    }

}
