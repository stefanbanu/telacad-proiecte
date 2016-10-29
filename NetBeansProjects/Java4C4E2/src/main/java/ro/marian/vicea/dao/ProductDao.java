package ro.marian.vicea.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.marian.vicea.db.ProduseDB;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public void adaugaProdus(ProduseDB produs) {
        em.persist(produs);
        //em.flush();
    }
}
