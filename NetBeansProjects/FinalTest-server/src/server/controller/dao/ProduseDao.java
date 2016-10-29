/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ProduseDB;
/**
 *
 * @author Stefan
 */
public class ProduseDao {
    public EntityManager em;

    public ProduseDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaProdus(ProduseDB p){
        em.persist(p);
    }
    public List<ProduseDB> findAll(){
        Query q = em.createNamedQuery("ProduseDB.findAll", ProduseDB.class);
        return q.getResultList();
    }

    public void stergeProd(ProduseDB p) {

        p = em.merge(p); // merge and assign a to the attached entity 
           
        em.remove(p);
    }
}
