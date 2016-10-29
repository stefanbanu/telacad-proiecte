/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
        try{
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/java2curs2bis";
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO clienti VALUES (NULL,'Gigel','Pop')";
            stmt.execute(sql);
            System.out.println("A fost executata interogarea");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
