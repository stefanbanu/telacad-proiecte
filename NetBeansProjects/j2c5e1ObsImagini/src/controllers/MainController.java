/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Imagini;
import beans.Useri;
import controllers.exceptions.ExisentUserException;
import controllers.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laur
 */
public class MainController {
    private UseriJpaController userController;
    private ImaginiJpaController imaginiController;
    private EntityManagerFactory emf;
    private static MainController singleton = null;
    
    private MainController(){
        emf = Persistence.createEntityManagerFactory("j2c5e1PU");
        userController = new UseriJpaController(emf);
        imaginiController = new ImaginiJpaController(emf);
    }
    
    public static MainController getInstance(){
        if(singleton == null) singleton = new MainController();
        return singleton;
    }
    
    public Useri verificaUser(Useri u){
        return userController.getUserByName(u.getNume());
        
    }
    
    public void addUser(Useri u) throws ExisentUserException{
        if(verificaUser(u) == null) userController.create(u);
        else throw new ExisentUserException();
    }
    
    public Useri login(Useri useri){
        Useri u = userController.getUserByName(useri.getNume());
        if(u != null){
            if(u.getParola().equals(useri.getParola())){
                return u;
            }else return null;
        }else return null;
    }
    
    public void adaugaImagine(Imagini imagine){
        imaginiController.create(imagine);
    }
    
    public List<Imagini> getImaginiByUser(Useri useri){
        return imaginiController.getImaginiByUser(useri.getId());
    }

    public ImaginiJpaController getImaginiController() {
        return imaginiController;
    }
    
    public void stergeImagine(Imagini imagini){
        try {
            imaginiController.destroy(imagini.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
