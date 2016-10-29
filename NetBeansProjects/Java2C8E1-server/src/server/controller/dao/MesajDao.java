package server.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import server.db.MesajDB;
import server.db.UsersDB;

public class MesajDao {
    private EntityManager em;

    public MesajDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaMesaj(MesajDB mesaj) {
        em.persist(mesaj);
    }
    
    public List<MesajDB> getAllMesajeByUser(UsersDB user) {
        Query q = em.createNamedQuery("MesajDB.findByUser", MesajDB.class);
        q.setParameter("user", user);
        
        return q.getResultList();
    }
}
