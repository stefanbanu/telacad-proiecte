/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Useri;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laur
 */
public class Controller {
    private static Controller controller;
    private EntityManagerFactory emf;
    private UseriJpaController c1;
    
    private Controller(){
        emf = Persistence.createEntityManagerFactory("j2c4e4PU");
        c1 = new UseriJpaController(emf);
        
    }
    
    public static Controller getInstance(){
        if(controller == null) controller = new Controller();
        return controller;
    }
    
    public Useri login(Useri user){
        List<Useri> useri = c1.getUseriByUser(user.getUser());
        if(useri.size()>0){
           if(useri.get(0).getParola().equals(user.getParola())){
               return useri.get(0);
           }else return null;
        }else return null;
    }
}
