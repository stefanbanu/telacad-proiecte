/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.dto;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Comanda implements Serializable{
    private Cod cod;
    
    public static enum Cod implements Serializable{
        INREGISTRARE,
        LOGIN,
        ADDMESAJ,
        GETMESAJE
    }

    public Comanda(Cod cod) {
        this.cod = cod;
    }

    public Cod getCod() {
        return cod;
    }
       
}
