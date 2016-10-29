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
    }
    
    public List<ProdusDB> findAllProducts(){
        Query q = em.createNamedQuery("ProdusDB.findAll");
        return q.getResultList();
    }
}
