package controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Users;

public class UsersDao {
    private EntityManager em;
    
    public UsersDao(EntityManager em) {
        this.em = em;
    }
    
    public Users findUserByUsername(String username) {
        try {
            Query q = em.createNamedQuery("Users.findByUsername", Users.class);
            q.setParameter("username", username);
            return (Users) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void addUser(Users user) {
        em.persist(user);
    }
}
