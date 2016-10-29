
package main;

import controllers.UseriJpaController;
import gui.Fereastra;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf;
    public static UseriJpaController controller;

    public static void main(String args[]) {
        emf = Persistence.createEntityManagerFactory("Java2Curs4Jpa2PU");
        controller = new UseriJpaController(emf);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fereastra().setVisible(true);
            }
        });
    }
}
