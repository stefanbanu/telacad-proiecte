/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.dao;

import org.springframework.stereotype.Repository;
import ro.telacad.db.Product;

/**
 *
 * @author student
 */
@Repository
public class ProductDao {
    
    public void adaugaProdus(Product p){
        System.out.println("A fost adaugat produsul "+p.getNume());
    }
}
