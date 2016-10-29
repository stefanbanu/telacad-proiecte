/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.AngajatDB;

/**
 *
 * @author student
 */
public class AngajatDao {
    private EntityManager em;
    
    public AngajatDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaAngajat(AngajatDB angajat){
        em.persist(angajat);
    }
    
    public void stergeAngajat(AngajatDB angajat){
        em.remove(angajat);
    }
    
    public void modificaAngajat(AngajatDB angajat){
        em.merge(angajat);
    }
    
    public List<AngajatDB> getAllAngajat(){
        Query q = em.createNamedQuery("AngajatDB.findAll");
        return q.getResultList();
    }
}
