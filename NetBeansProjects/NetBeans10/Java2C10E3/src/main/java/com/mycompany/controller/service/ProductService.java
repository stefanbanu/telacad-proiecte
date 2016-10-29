/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller.service;

import com.mycompany.controller.dao.ProdusDao;
import com.mycompany.db.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED) // Spring face automat tranzactia
public class ProductService {
    @Autowired // Ia instanta direct din registrul Spring
    // Autowired foloseste patternul "Dependency Injection"
    private ProdusDao produsDao;
    
    public void adaugaProdus(String nume) {
        Produs produs = new Produs();
        produs.setNume(nume);
        
        produsDao.adaugaProdus(produs);
    }
}
