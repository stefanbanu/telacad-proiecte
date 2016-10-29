/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.service;

import dto.ProductDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IProductService;
import server.dao.ProdusDao;
import server.db.ProdusDB;
import server.util.ProductMapper;

/**
 *
 * @author student
 */
public class ProductService extends UnicastRemoteObject 
                                    implements IProductService{
    private EntityManagerFactory emf;
    
    private ProductService() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("java2c9e3-serverPU");
    }
    
    private static final class SingletonHolder{
        private static ProductService SINGLETON;
        static{
            try{
                SINGLETON = new ProductService();
            }catch(RemoteException e){e.printStackTrace();}
        }
    }
    
    public static ProductService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    @Override
    public void adaugaProdus(ProductDTO produs){
        EntityManager em = getEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try{
            em.getTransaction().begin();
            produsDao.adaugaProdus(ProductMapper.convert(produs));
            em.getTransaction().commit();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    @Override
    public List<ProductDTO> getAllProducts(){
        EntityManager em = getEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        List<ProductDTO> produse = new ArrayList<>();
        List<ProdusDB> list = produsDao.findAll();
        
        for(ProdusDB p: list){
            produse.add(ProductMapper.convert(p));
        }
        
        return produse;
    }
}
