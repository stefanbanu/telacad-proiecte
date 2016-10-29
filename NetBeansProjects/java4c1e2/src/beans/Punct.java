/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import main.Aleator;
import main.Atribuie;

/**
 *
 * @author student
 */

public class Punct {
    
    @Atribuie
    private int x;
    
    @Aleator
    private int y;
    
    private Punct(){
        
    }
    
    private void afisareXY(){
        System.out.println("COORDONATE: "+x+" "+y);
    }
}
