/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Carduri;
import beans.Clienti;
import controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laur
 */
public class Controller {
    private static Controller controller=null;
    private EntityManagerFactory emf;
    private CarduriJpaController c1;
    private ClientiJpaController c2;
    
    private Controller(){
        emf = Persistence.createEntityManagerFactory("j2c4e3PU");
        c1 = new CarduriJpaController(emf);
        c2 = new ClientiJpaController(emf);
    }
    
    public static Controller getInstance(){
        if(controller == null) controller = new Controller();
        return controller;
    }
    
    public List<Clienti> getClienti(){
        List<Clienti> findClientiEntities = c2.findClientiEntities();
        return findClientiEntities;
    }
    
    public List<Carduri> getCarduriFromClient(Integer id){
        List<Carduri> carduri = c1.getCarduriByClient(id);
        return carduri;
    }
    
    public void stergeCard(Carduri c) throws NonexistentEntityException{
        c1.destroy(c.getId());
    }
    
    public void modificaCard(Carduri c) throws Exception{
        c1.edit(c);
    }

    public CarduriJpaController getC1() {
        return c1;
    }

    public ClientiJpaController getC2() {
        return c2;
    }
    
    
    
}
