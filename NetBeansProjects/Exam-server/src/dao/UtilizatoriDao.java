/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.UtilizatoriDB;

/**
 *
 * @author student
 */
public class UtilizatoriDao {
    
    private EntityManager em;

    public UtilizatoriDao(EntityManager em) {
        this.em = em;
    }
    
     public void adaugaUser(UtilizatoriDB user){

        em.persist(user);
    }
    
    public UtilizatoriDB findUser(String user){
        Query q = em.createNamedQuery("UtilizatoriDB.findAll", UtilizatoriDB.class);
        q.setParameter("user", user);
        
        try {
            return (UtilizatoriDB) q.getSingleResult();
        } catch (Exception e) {
                e.printStackTrace();
            return null;
        }
    }
    
      public List<UtilizatoriDB> getUseriByUser(String user){
        Query q = em.createNamedQuery("UtilizatoriDB.findByUser", UtilizatoriDB.class);
        q.setParameter("user", user);
        List<UtilizatoriDB> useri = (List<UtilizatoriDB>) q.getResultList();
        return useri;
    }
    
}
