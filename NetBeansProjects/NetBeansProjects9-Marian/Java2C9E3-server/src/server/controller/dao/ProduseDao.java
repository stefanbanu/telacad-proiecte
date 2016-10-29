package server.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import server.model.ProduseDB;

public class ProduseDao {
    public EntityManager em;

    public ProduseDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaProdus(ProduseDB produs) {
        em.persist(produs);
    }
    
    public List<ProduseDB> findAll() {
        Query q = em.createNamedQuery("ProduseDB.findAll", ProduseDB.class);
        return q.getResultList();
    }
}
