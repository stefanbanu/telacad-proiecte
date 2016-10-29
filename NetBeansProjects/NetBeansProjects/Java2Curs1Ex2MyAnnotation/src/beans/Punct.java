/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import annotations.Aleator;

/**
 *
 * @author student
 */

public class Punct {
    
    @Aleator
    private int x;
    
    @Aleator
    private int y;
    
    private int z;
    
    private Punct(){}
    
    private Punct(String mesaj){
        System.out.println(mesaj);
    }
    
    public void afisareXYZ(){
        System.out.println(x+" "+y+" "+z);
    }
}
