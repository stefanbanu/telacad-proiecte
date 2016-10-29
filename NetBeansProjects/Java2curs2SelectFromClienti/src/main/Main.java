/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {


    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost/java2curs2bis";
            Connection con = DriverManager.getConnection(url,"root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clienti");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                System.out.println(id+" "+nume+" "+prenume);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
