/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.ProductDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Produs;

/**
 *
 * @author student
 */
public class ProductService {
    private Connection con;
    private ProductDao productDao;
    private ProductService(){
        try{
            String url = "jdbc:mysql://localhost/java2curs2test";
            con = DriverManager.getConnection(url, "root","");
            productDao = new ProductDao(con);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ProductService SINGLETON = new ProductService();
    }
    
    public static ProductService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaProdus(String nume){
        Produs produs = new Produs(nume);
        productDao.adaugaProdus(produs);
    }
}
