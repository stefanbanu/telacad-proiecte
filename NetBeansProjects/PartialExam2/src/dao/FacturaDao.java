/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.FacturiDB;

/**
 *
 * @author Stefan
 */
public class FacturaDao {
    EntityManager em;

    public FacturaDao(EntityManager em) {
        this.em = em;
    }
    
    
     public void addFactura(FacturiDB f){
        em.persist(f);
    }
     
     public List<FacturiDB> getAllFacturi(){
         Query q = em.createNamedQuery("FacturiDB.findAll");
         
         return q.getResultList();
     }
    
}
