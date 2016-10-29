/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Produs;

/**
 *
 * @author student
 */
public class ProductDao {
    private Connection con;
    
    public ProductDao(Connection con){
        this.con = con;
    }
    
    public void adaugaProdus(Produs product){
        try(Statement stmt = con.createStatement()){
            String sql = "INSERT INTO produse VALUES (NULL, '"
                    +product.getNume()+"')";
            stmt.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
