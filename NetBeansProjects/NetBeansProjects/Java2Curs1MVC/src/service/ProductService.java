/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.ProductDao;
import model.Product;

/**
 *
 * @author student
 */
public class ProductService {
    private ProductDao productDao;
    
    private ProductService(){
        productDao = new ProductDao();
    }
    
    private static final class SingletonHolder{
        private static final ProductService SINGLETON = new ProductService();
    }
    
    public static ProductService getIntance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaZeceProduse(){
        for(int i=1;i<=10;i++){
            Product p = new Product();
            p.setNume("PRODUCT "+i);
            p.setPret(10);
            productDao.addProduct(p);
        }
    }
}
