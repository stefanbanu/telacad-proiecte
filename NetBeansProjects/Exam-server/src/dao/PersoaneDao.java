/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PersoaneDB;

/**
 *
 * @author student
 */
public class PersoaneDao {
    private EntityManager em;

    public PersoaneDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaPersoana(PersoaneDB p){
        em.persist(p);
    }
    public List<PersoaneDB> findAll(){
        Query q = em.createNamedQuery("PersoaneDB.findAll", PersoaneDB.class);
        return q.getResultList();
    }

    public void stergePersoana(PersoaneDB p) {

        p = em.merge(p); // merge and assign a to the attached entity           
        em.remove(p);
    }
}
