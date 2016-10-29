/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.UserDao;
import java.util.List;
import model.User;
import tx.TransactionManager;
import utils.Utils;

/**
 *
 * @author student
 */
public class LoginService {
    private UserDao userDao;
    
    private LoginService(){
        userDao = new UserDao();
    }
    
    private static final class SingletonHolder{
        private static final LoginService SINGLETON = new LoginService();
    }
    
    public static LoginService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public User login(String username, String password) {
        try {
            TransactionManager.getInstance().startTransaction();
            User user = userDao.findUserByUsername(username);
            if (user != null) {
                password = Utils.encryptPasswordMD5(password);
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
            TransactionManager.getInstance().commit();
        } catch (Exception e) {
            TransactionManager.getInstance().rollback();
        }
        return null;
    }
    
    public boolean register(String username, String password){
        try{
            TransactionManager.getInstance().startTransaction();
            User user = userDao.findUserByUsername(username);
            if(user == null){
                password = Utils.encryptPasswordMD5(password);
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userDao.adaugaUser(user);
                TransactionManager.getInstance().commit();
                return true;
            }
        }catch(Exception e){
            TransactionManager.getInstance().rollback();
        }
        return false;
    }
    
    public List<User> getAllOtherUsers(int userID){
        List<User> users = null;
        try{
            TransactionManager.getInstance().startTransaction();
            users = userDao.getAllOtherUsers(userID);
            TransactionManager.getInstance().commit();
        }catch(Exception e){
            TransactionManager.getInstance().rollback();
        }
        return users;
    }
}
