/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.AngajatDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.AngajatDB;

/**
 *
 * @author student
 */
public class AngajatService {
    private EntityManagerFactory emf;
    private EntityManager em;
    private AngajatDao angajatDao;
    
    private AngajatService(){
        emf = Persistence.createEntityManagerFactory("java2c4e2PU");
        em = emf.createEntityManager();
        angajatDao = new AngajatDao(em);
    }
    
    private final static class SingletonHolder{
        private final static AngajatService SINGLETON = new AngajatService();
    }
    
    public static AngajatService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaAngajat(String nume, String prenume){
        em.getTransaction().begin();
        AngajatDB angajat = new AngajatDB();
        angajat.setNume(nume);
        angajat.setPrenume(prenume);
        angajatDao.adaugaAngajat(angajat);
        em.getTransaction().commit();
    }
    
    public void stergeAngajat(AngajatDB angajat){
        em.getTransaction().begin();
        angajatDao.stergeAngajat(angajat);
        em.getTransaction().commit();
    }
    
    public void modificaAngajat(AngajatDB angajat){
        em.getTransaction().begin();
        angajatDao.modificaAngajat(angajat);
        em.getTransaction().commit();
    }
    
    public List<AngajatDB> getAngajati(){
        return angajatDao.getAllAngajat();
    }
}
