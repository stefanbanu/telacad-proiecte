/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.telacad.dao.ProductDao;

/**
 *
 * @author student
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductDao produsDao;
    
    public void adaugaProdus(String nume){
        produsDao.adaugaProdus(nume);
    }
    
     public void stergeProdus(String nume){
        produsDao.stergeProdus(nume);
    }
}
