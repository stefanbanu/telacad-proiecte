/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tx;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class Transaction {
    private Connection con;
    
    public Transaction(Connection con){
        this.con = con;
    }
    
    public void startTransaction() throws SQLException{
        con.setAutoCommit(false);
    }
    
    public Connection getConnection(){
        return this.con;
    }
}
