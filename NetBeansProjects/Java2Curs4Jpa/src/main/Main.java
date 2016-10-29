
package main;

import beans.Useri;
import controllers.UseriJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import view.Fereastra;

public class Main {

    /* public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java2Curs4JpaPU");
        UseriJpaController c = new UseriJpaController(emf);
        
        Useri u1 =  new Useri(0, "gica", "12345");
        c.create(u1); 
        
    } */
    
    static EntityManagerFactory emf;
    public static UseriJpaController controller;
    
    public static void main(String args[]) {

        emf = Persistence.createEntityManagerFactory("Java2Curs4JpaPU");
        controller = new UseriJpaController(emf);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fereastra().setVisible(true);
            }
        });
    }
    
}
