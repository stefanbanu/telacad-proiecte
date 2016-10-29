package server.controller.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lib.dto.ProduseDto;
import lib.rmi.IProduseService;
import server.controller.dao.ProduseDao;
import server.model.ProduseDB;
import server.util.ProductMapper;

public class ProduseService extends UnicastRemoteObject implements IProduseService {
    private EntityManagerFactory emf;
    
    private ProduseService() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("Java2C10E2-serverPU");
    }


    
    private static final class SingletonHolder {
        private static ProduseService INSTANCE;
        static {
            try {
                INSTANCE = new ProduseService();
            } catch(RemoteException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static ProduseService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void adaugaProdus(ProduseDto produs) throws RemoteException {
        EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
        try {
            em.getTransaction().begin();
            produseDao.adaugaProdus(ProductMapper.convert(produs));
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        @Override
    public void deleteProdus(ProduseDto produs) throws RemoteException {
        EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
         try {
            em.getTransaction().begin();
            produseDao.stergeProdus(ProductMapper.convert(produs));
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<ProduseDto> listaProduse() throws RemoteException {
        EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
        List<ProduseDB> produse = produseDao.getAllProduse();
        List<ProduseDto> listaProduse = new ArrayList<>();
        produse.forEach(p -> listaProduse.add(ProductMapper.convert(p)));
        
        if (em != null) {
            em.close();
        }
        
        return listaProduse;
    }
}
