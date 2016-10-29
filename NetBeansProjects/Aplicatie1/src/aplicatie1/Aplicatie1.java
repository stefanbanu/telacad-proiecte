/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicatie1;

import javax.swing.*;
import java.awt.*;



/**
 *
 * @author Stefan
 */
public class Aplicatie1 {

    public static FereastraPrincipala f = new FereastraPrincipala("Titlu de fereastra");
    public static JInternalFrame fr = new JInternalFrame("frame intern", true, true, true, true);
     public static JDesktopPane desktop = new JDesktopPane(); //a specialized layered pane
    
    public static void main(String[] args) {
        
        desktop.add(fr);
        f.setBounds(200, 200, 500, 500);
        f.add(desktop);
        
        f.setVisible(true);
		
        
        
    }
    
}
