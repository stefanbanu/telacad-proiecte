/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author student
 */
public class UserDao {
    
    private Connection con;
    
    private PreparedStatement stmtSelectByUsername;
    private PreparedStatement stmtAddUser;
    
    public UserDao(Connection con){
        this.con = con;
        
        try {
            stmtSelectByUsername = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmtAddUser = con.prepareStatement("INSERT INTO users VALUES (NULL, ? ,?)");
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User findUserByUsername(String username) throws SQLException{
        stmtSelectByUsername.setString(1, username);
        
        try(ResultSet rs = stmtSelectByUsername.executeQuery()){
        
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setParola(rs.getString("parola"));
                return user;
            }
        }
        return null;
    }
    
    public void addUser(User user) throws SQLException{
        stmtAddUser.setString(1, user.getUsername());
        stmtAddUser.setString(2, user.getParola());
        stmtAddUser.executeUpdate();
    }
}
