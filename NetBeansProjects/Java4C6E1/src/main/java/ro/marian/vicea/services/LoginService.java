package ro.marian.vicea.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.marian.vicea.dao.UserDao;
import ro.marian.vicea.model.User;

@Service
public class LoginService {
    
    @Autowired
    private UserDao userDao;
    
    public void adaugaUser(String username, String password) {
        userDao.adaugaUser(username, password);
    }
    
    public boolean login(String username, String password) {
        User user = userDao.findUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    }
}
