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

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost/java2curs2test";
            Connection con = DriverManager.getConnection(url,"root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produse");
            while(rs.next()){
                int id = rs.getInt(1);
                String nume = rs.getString(2);
                System.out.println(id+" "+nume);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
