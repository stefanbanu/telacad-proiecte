/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DetaliiFacturiDao;
import dao.FacturaDao;
import dao.ProdusDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.FacturiDB;
import obspattern.Observer;
import obspattern.Subject;

/**
 *
 * @author Stefan
 */
public class ServiceController implements Subject{
    
    EntityManager em;
    EntityManagerFactory emf;
    
    ProdusDao pDao;
    FacturaDao fDao;
    DetaliiFacturiDao dfDao;
    

    private ServiceController() {
        emf = Persistence.createEntityManagerFactory("PartialExam2PU");
        em = emf.createEntityManager();
        
        pDao = new ProdusDao(em);
        fDao = new FacturaDao(em);
        dfDao = new DetaliiFacturiDao(em);
        
    }

    @Override
    public void addObserver(Observer o) {
       obs.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
       obs.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer ob : obs) {
            ob.update();
        }
    }

    private static final class SingletonHolder {

        private static final ServiceController SINGLETON  = new ServiceController();
    }
    
    public static final ServiceController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public List<FacturiDB> getAllFacturi(){
        return fDao.getAllFacturi();
    }
    
    public void adaugaFactura(String serieFactura, String nrFactura){
        try {
            em.getTransaction().begin();
            FacturiDB f = new FacturiDB();
            f.setSerieFactura(serieFactura);
            f.setNumarFactura(nrFactura);
            fDao.addFactura(f);
            notifyAllObservers();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
