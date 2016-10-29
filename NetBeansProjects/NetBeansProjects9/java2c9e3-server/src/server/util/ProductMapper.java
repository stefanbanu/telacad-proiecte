/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.util;

import dto.ProductDTO;
import server.db.ProdusDB;

/**
 *
 * @author student
 */
public class ProductMapper {
    public static ProductDTO convert(ProdusDB produs){
        ProductDTO p = new ProductDTO();
        p.setId(produs.getId());
        p.setNume(produs.getNume());
        return p;
    }
    
    public static ProdusDB convert(ProductDTO produs){
        ProdusDB p = new ProdusDB();
        p.setId(produs.getId());
        p.setNume(produs.getNume());
        return p;
    }
}
