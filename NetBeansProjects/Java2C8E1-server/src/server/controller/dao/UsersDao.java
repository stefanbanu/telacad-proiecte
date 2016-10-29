package server.controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import server.db.UsersDB;

public class UsersDao {
    private EntityManager em;

    public UsersDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaUser(UsersDB user) {
        em.persist(user);
    }
    
    // In Java 8 ar trebui sa nu mai folosim null, ci:
    // public Optional<UsersDB> findUser(String username) {
    public UsersDB findUser(String username) {
        Query q = em.createNamedQuery("UsersDB.findByUsername", UsersDB.class);
        q.setParameter("username", username);
        
        try {
            // return Optional.ofNullable((UsersDB) q.getSingleResult());
            return (UsersDB) q.getSingleResult();
        } catch (Exception e) {
            // return Optional.empty();
            return null;
        }
    }
}
