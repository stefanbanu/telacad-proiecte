/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.ProdusDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.ProdusDB;

/**
 *
 * @author student
 */
public class ProductService {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private ProdusDao produsDao;
    
    private ProductService(){
        emf = Persistence.createEntityManagerFactory("java2c4e1PU");
        em = emf.createEntityManager();
        produsDao = new ProdusDao(em);
    }
    
    private static final class SingletonHolder{
        private static final ProductService SINGLETON = new ProductService();
    }
    
    public static ProductService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaZeceProduse(){
        em.getTransaction().begin();
        ProdusDB produs = null;
        for(int i=1;i<=10;i++){
            produs = new ProdusDB();
            produs.setNume("PRODUS "+i);
            produs.setPret(i);
            produsDao.adaugaProdus(produs);
        }
        em.getTransaction().commit();
    }
    
    public List<ProdusDB> findProductsByName(String nume){
        return produsDao.findProductByName(nume);
    }
    
    public List<ProdusDB> findProductsWithPriceBetween(double min, double max){
        return produsDao.findProductsWithPriceBetween(min, max);
    }
}
