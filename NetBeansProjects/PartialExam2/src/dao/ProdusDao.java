/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import model.ProduseDB;

/**
 *
 * @author Stefan
 */
public class ProdusDao {
    EntityManager em;

    public ProdusDao(EntityManager em) {
        this.em = em;
    }
    
     public void addProdus(ProduseDB p){
        em.persist(p);
    }
}
