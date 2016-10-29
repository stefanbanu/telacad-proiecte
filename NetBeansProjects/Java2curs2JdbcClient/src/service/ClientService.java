/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.ClientDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;

/**
 *
 * @author student
 */
public class ClientService {
    private Connection con;
    
    private ClientDao clientDao;
    
    private ClientService(){
        String url = "jdbc:mysql://localhost/java2curs2bis";
        try {
            con = DriverManager.getConnection(url,"root","");
            clientDao = new ClientDao(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ClientService SINGLETON = new ClientService();
    }
    
    public static ClientService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaClient(String nume, String prenume){
        Client client = new Client(nume, prenume);
        clientDao.adaugaClient(client);
    }
}
