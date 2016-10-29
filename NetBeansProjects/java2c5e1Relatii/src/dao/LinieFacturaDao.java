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
import model.LinieFacturaDB;

/**
 *
 * @author student
 */
public class LinieFacturaDao {
    private EntityManager em;
    
    public LinieFacturaDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaLinieFactura(LinieFacturaDB linieFactura){
        em.persist(linieFactura);
    }
    
    public List<LinieFacturaDB> getAllLiniiFactura(FacturaDB factura){
        Query q = em.createNativeQuery(
        "SELECT * FROM liniifacturi lf WHERE lf.factura = ?",
        LinieFacturaDB.class);
        
      //  Query q = em.createNamedQuery("LinieFacturaDB.findAll");
        
        q.setParameter(1, factura.getId());
        return q.getResultList();
    }
}
