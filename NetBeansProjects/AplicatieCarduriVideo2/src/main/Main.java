
package main;

import gui.MainFrame;

public class Main {

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             MainFrame mf =  new MainFrame();
             
             mf.setLocationRelativeTo(null);
             mf.setVisible(true);
            }
        });
    }
}
