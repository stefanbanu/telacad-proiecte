/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author student
 */
public class LoginService {
    private LoginService(){
        
    }
    
    private static final class SingletonHolder{
        private static final LoginService SINGLETON = new LoginService();
    }
    
    public static LoginService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean login(String username, String parola){
        if("gigel".equals(username) && "12345".equals(parola)){
            return true;
        }
        return false;
    }
}
