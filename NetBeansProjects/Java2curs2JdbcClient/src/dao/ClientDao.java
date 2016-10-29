/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Client;

/**
 *
 * @author student
 */
public class ClientDao {
    private Connection con;
    
    public ClientDao(Connection con){
        this.con = con;
    }
    
    public void adaugaClient(Client client){
        String sql = 
                "INSERT INTO clienti VALUES (NULL,'"+
                client.getNume()+"','"+
                client.getPrenume()+"')";
        
        try(Statement stmt = con.createStatement()){
            stmt.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
