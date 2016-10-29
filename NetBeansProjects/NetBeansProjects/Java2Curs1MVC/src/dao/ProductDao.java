/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Product;

/**
 *
 * @author student
 */
public class ProductDao {
    
    public void addProduct(Product p){
       System.out.println("Am adaugat produsul "+p.getNume()+" "+p.getPret());
    }
    
    
}
