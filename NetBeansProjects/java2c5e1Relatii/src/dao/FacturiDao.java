/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.FacturaDB;

/**
 *
 * @author student
 */
public class FacturiDao {
    private EntityManager em;
    
    public FacturiDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaFactura(FacturaDB factura){
        em.persist(factura);
        
    }
    
    public List<FacturaDB> getAllFacturi(){
        Query q = em.createNamedQuery("FacturaDB.findAll");
        return q.getResultList();
    }
}
