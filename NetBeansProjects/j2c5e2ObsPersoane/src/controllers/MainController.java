/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Persoane;
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
    
    private static MainController singleton;
    private EntityManagerFactory emf;
    private PersoaneJpaController persoaneController;
    
    private MainController(){
        emf = Persistence.createEntityManagerFactory("j2c5e2PU");
        persoaneController = new PersoaneJpaController(emf);
    }
    
    public static MainController getInstance(){
        if(singleton == null) singleton = new MainController();
        return singleton;
    }
    
    public void adaugaPersoana(Persoane p){
        persoaneController.create(p);
    }
    
    public List<Persoane> getPersoane(){
        return persoaneController.findPersoaneEntities();
    }

    public PersoaneJpaController getPersoaneController() {
        return persoaneController;
    }
    
    public void modificaPersoana(Persoane p){
        try {
            persoaneController.edit(p);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stergePersoana(Persoane p){
        try {
            persoaneController.destroy(p.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
