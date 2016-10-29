/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import controller.dao.UsersDao;
import db.UsersDB;
import dto.Raspuns;
import dto.UserDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stefan
 */
public class MainService {
    private EntityManagerFactory emf;
    
    private MainService(){
        emf = Persistence.createEntityManagerFactory("java2curs8-serverPU");
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    private static final class SingletonHolder {
        private static final MainService SINGLETON = new MainService();
    } 
    
    public static MainService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public Raspuns register(UserDTO uDto){
        EntityManager em = getEntityManager();
        UsersDao uDao = new UsersDao(em);
        
        try {
            UsersDB u = uDao.findUser(uDto.getUsername());
            
            if(u == null){
                u = new UsersDB();
                u.setUsername(uDto.getUsername());
                u.setPassword(uDto.getPassword());
                
                em.getTransaction().begin();
                uDao.adaugaUser(u);
                em.getTransaction().commit();
                return new Raspuns(Raspuns.Cod.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            if(em != null){
                em.close();
            }
        }
        
        return new Raspuns(Raspuns.Cod.NOTOK);
    }
}
