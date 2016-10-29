/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author student
 */
public class RegisterService {
    private RegisterService(){
        
    }
    
    private static final class SingletonHolder{
        private static final RegisterService SINGLETON = new RegisterService();
    }
    
    public static RegisterService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean registerUser(String username, String parola){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/java3curs2","root","");
            UserDao userDao = new UserDao(con);
            User user = userDao.findUserByUsername(username);
            if(user == null){
                user = new User(username, parola);
                userDao.addUser(user);
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if(con != null) try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return false;
    }
}
