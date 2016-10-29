/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
import tx.TransactionManager;

/**
 *
 * @author student
 */
public class UserDao {

    public User findUserByUsername(String username){
        Connection con = null;
        PreparedStatement ps1 = null;
        try{
            con = TransactionManager.getInstance().getCurrentConnection();
            ps1 = con.prepareStatement(
                "SELECT * FROM users u WHERE u.username = ?");
            ps1.setString(1, username);
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                return user;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void adaugaUser(User user){
        Connection con = null;
        PreparedStatement ps2 = null;
        try{
            con = TransactionManager.getInstance().getCurrentConnection();
            ps2 = con.prepareStatement("INSERT INTO users VALUES (NULL,?,?)");
            ps2.setString(1, user.getUsername());
            ps2.setString(2, user.getPassword());
            ps2.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<User> getAllOtherUsers(int userID) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();
        try{
           con = TransactionManager.getInstance().getCurrentConnection();
           stmt = con.prepareStatement("SELECT * FROM users u WHERE u.id != ?");
           stmt.setLong(1, userID);
           rs = stmt.executeQuery();
            
           while(rs.next()){
               user = new User();
               user.setId(rs.getInt("id"));
               user.setUsername(rs.getString("username"));
               user.setPassword(rs.getString("password"));
               users.add(user);
           }
        }finally{
            if(rs!=null) rs.close();
            if(stmt != null) stmt.close();
        }
        return users;
    }
}
