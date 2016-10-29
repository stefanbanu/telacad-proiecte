/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class TransactionManager {
    private ThreadLocal<Transaction> currentTransaction = new ThreadLocal<>();
    
    private String url;
    private String username;
    private String password;
    
    private TransactionManager(){
        url = "jdbc:mysql://localhost/java2curs3";
        username = "root";
        password = "";
    }
    
    private static final class SingletonHolder{
        private static final TransactionManager SINGLETON = 
                new TransactionManager();
    }
    
    public static TransactionManager getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public void startTransaction() throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        Transaction trans = new Transaction(con);
        trans.startTransaction();
        currentTransaction.set(trans);
    }
    
    public Connection getCurrentConnection(){
        return currentTransaction.get().getConnection();
    }
    
    public void commit(){
        try{
            currentTransaction.get().getConnection().commit();
            currentTransaction.get().getConnection().close();
            currentTransaction.remove();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void rollback(){
        try{
            currentTransaction.get().getConnection().rollback();
            currentTransaction.get().getConnection().close();
            currentTransaction.remove();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
