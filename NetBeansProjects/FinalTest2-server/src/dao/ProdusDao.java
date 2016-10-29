/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ProduseDB;

/**
 *
 * @author Stefan
 */
public class ProdusDao {
    private EntityManager em;

    public ProdusDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaProdus(ProduseDB p){
        em.persist(p);
    }
    
     public void stergeProdus(ProduseDB p){
        p = em.merge(p);
         
         em.remove(p);
    }
     public List<ProduseDB> getListProduseDB(){
         Query q = em.createNamedQuery("ProduseDB.findAll", ProduseDB.class);
         
         return q.getResultList();        
     }
    
}
