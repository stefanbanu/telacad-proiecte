/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import server.db.ProdusDB;

/**
 *
 * @author student
 */
public class ProdusDao {
    private EntityManager em;
    
    public ProdusDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaProdus(ProdusDB produs){
        em.persist(produs);
    }
    
    public List<ProdusDB> findAll(){
        Query q = em.createNativeQuery("SELECT * FROM produse", ProdusDB.class);
        return q.getResultList();
    }
}
