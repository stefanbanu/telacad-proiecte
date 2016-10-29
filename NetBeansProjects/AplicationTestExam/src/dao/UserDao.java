/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Useri;
import obspattern.SubiectUseri;
import obspattern.UseriListener;

/**
 *
 * @author Stefan
 */
public class UserDao {
    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaUser(Useri u){
        em.persist(u);
    }
    
    public void stergeUser(Useri u){
        em.remove(u);
    }
    
    public void modificaUser(Useri u){
        em.merge(u);
    }
    
    public List<Useri> getAllUsers(){
        Query q = em.createNamedQuery("Useri.findAll");
        
        return q.getResultList();
    }
    
    public List<Useri> findUserByUsername(String user){
        Query q = em.createNamedQuery("Useri.findByUser");
        q.setParameter("user", user);
        List<Useri> useri = q.getResultList();
        
        return useri;
    }
     public List<Useri> getAllAngajat(){
        Query q = em.createNamedQuery("AngajatDB.findAll");
        return q.getResultList();
    }

  
    
}
