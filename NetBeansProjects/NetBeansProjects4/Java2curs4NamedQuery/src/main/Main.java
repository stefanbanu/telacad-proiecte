/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.List;
import model.ProdusDB;
import service.ProductService;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) {
        List<ProdusDB> produse = 
                ProductService.getInstance().findProductsWithPriceBetween(5, 7);
        for(ProdusDB p:produse){
            System.out.println(p.getId()+" "+p.getNume()+" "+p.getPret());
        }
    }
    
}
