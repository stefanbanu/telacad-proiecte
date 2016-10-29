/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FacturiDao;
import dao.LiniiFacturiDao;
import dao.ProduseDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Facturi;
import model.Liniifacturi;
import model.Produse;
import obspattern.Observer;
import obspattern.Subject;

/**
 *
 * @author Stefan
 */
public class ServiceController implements Subject{
    
    private EntityManager em;
    private EntityManagerFactory emf;
    
    private ProduseDao pDao;
    private LiniiFacturiDao lDao;
    private FacturiDao fDao;

    private ServiceController() {
        emf = Persistence.createEntityManagerFactory("PartialExamPU");
        em = emf.createEntityManager();
        
        pDao = new ProduseDao(em);
        lDao = new LiniiFacturiDao(em);
        fDao = new FacturiDao(em);
    }

    public List<Liniifacturi> getAllLiniiFacturi() {
        
     return lDao.getAllLinii();
    }
    
    private static final class SingletonHolder{
        private static final ServiceController SINGLETON = new ServiceController();
    }
    
    public static ServiceController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
      public void addProdus(String pName, double pPret){
          try {
              em.getTransaction().begin();
              Produse p = new Produse();
              p.setProdusNume(pName);
              p.setProdusPret(pPret);
              pDao.addProdus(p);
              em.getTransaction().commit();
          } catch (Exception e) {
              em.getTransaction().rollback();
                     
              e.printStackTrace();
          }
    }
    

    @Override
    public void addObserver(Observer o) {
        
    }

    @Override
    public void removeObserver(Observer o) {
        
        
    }

    @Override
    public void notifyObservers() {
        
        
    }
    
}
