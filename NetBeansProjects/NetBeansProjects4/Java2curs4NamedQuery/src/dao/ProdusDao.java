/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ProdusDB;

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
        em.flush();
    }
    
    public List<ProdusDB> findProductByName(String name){
        Query q = em.createNamedQuery("ProdusDB.findByNume");
        q.setParameter("nume", name);
        return q.getResultList();
    }
    
    public List<ProdusDB> findProductsWithPriceBetween(double min, double max){
        String sql = "SELECT * FROM produse p WHERE p.pret >= ? AND p.pret <= ?";
        Query q = em.createNativeQuery(sql, ProdusDB.class);
        q.setParameter(1, min);
        q.setParameter(2, max);
        
        return q.getResultList();
    }
}
