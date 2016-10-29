/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import obspattern.ProductListener;
import obspattern.Subject;

/**
 *
 * @author Stefan
 */
public class Produse implements Subject{

    private ArrayList<String> produseList = new ArrayList<>();
    
    public Produse() {
        produseList.add("Mere");
        produseList.add("banane");
        produseList.add("portocale");
        produseList.add("struguri");
    }
    
    public void afiseazaProduse(){
        System.out.println(produseList);
    }
    
    public void adaugaProdus(String numeProdus){
        produseList.add(numeProdus);
    }

    @Override
    public void addProductListener(ProductListener pl) {
        obs.add(pl);
    }

    @Override
    public void notifica() {
        for(ProductListener p : obs){
            p.listaModificata();
        }
    }
    
    
}
