/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.telacad.dao.ProductDao;
import ro.telacad.db.Product;

/**
 *
 * @author student
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductDao productDao;
    
    public void adaugaProdus(String nume, double pret){
        Product p = new Product();
        p.setNume(nume);
        p.setPret(pret);
        productDao.adaugaProdus(p);
    }
}
