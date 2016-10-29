package controller.service;

import controller.dao.UsersDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import model.Users;
import tx.TransactionManager;
import utils.Utils;

public class LoginService {
    private EntityManager em;
    private UsersDao usersDao;
    
    private LoginService() {
        em = TransactionManager.getInstance().getEntityManager();
        usersDao = new UsersDao(em);
    }
    
    private static final class SingletonHolder {
        private static final LoginService INSTANCE = new LoginService();
    }
    
    public static LoginService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public Users loginUser(String username, String password) {
        try {
            TransactionManager.getInstance().startTransaction();
            Users user = usersDao.findUserByUsername(username);
            TransactionManager.getInstance().commit();
            
            if (user != null) {
                password = Utils.encryptPasswordMD5(password);
                if (password.equals(user.getParola())) {
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionManager.getInstance().rollback();
        }
        
        return null;
    }
    
    public boolean registerUser(String username, String password) {
        try {
            TransactionManager.getInstance().startTransaction();
            Users user = usersDao.findUserByUsername(username);
            
            if (user == null) {
                password = Utils.encryptPasswordMD5(password);
                // Cream userul
                user = new Users(null, username, password);
                usersDao.addUser(user);
                
                TransactionManager.getInstance().commit();

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionManager.getInstance().rollback();
        }
        return false;
    }
}
