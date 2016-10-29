/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Facturi;
import model.Liniifacturi;

/**
 *
 * @author Stefan
 */
public class LiniiFacturiDao {
    private EntityManager em;

    public LiniiFacturiDao(EntityManager em) {
        this.em = em;
    }
    
      public List<Liniifacturi> getAllLinii() {
        
        Query q = em.createNamedQuery("Liniifacturi.findAll");
       // Query q = em.createNativeQuery("SELECT * FROM liniifacturi lf WHERE lf.factura = ?",LiniiFacturiDao.class);
                
   

        
        return q.getResultList();
    }
}
