/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Produse;

/**
 *
 * @author Stefan
 */
public class MainClass {
    
    public static void main(String[] args) {
        Produse p =new Produse();
        
        p.afiseazaProduse();
        p.adaugaProdus("mure");
        p.afiseazaProduse();
    }
    
}
