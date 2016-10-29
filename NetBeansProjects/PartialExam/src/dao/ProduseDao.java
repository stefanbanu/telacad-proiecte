/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import model.Produse;

/**
 *
 * @author Stefan
 */
public class ProduseDao {
    private EntityManager em;

    public ProduseDao(EntityManager em) {
        this.em = em;
    }
    
    public void addProdus(Produse p){
        em.persist(p);
    }
}
