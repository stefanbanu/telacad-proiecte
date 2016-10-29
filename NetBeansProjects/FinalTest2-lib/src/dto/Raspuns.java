/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Raspuns implements Serializable{
    private Cod cod;
    
    public static enum Cod implements Serializable{
        OK, NOTOK
    }

    public Raspuns(Cod cod) {
        this.cod = cod;
    }
    public Cod getCod(){
        return this.cod;
    }
}
