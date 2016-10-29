/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Mesaj implements  Serializable{
    private long cod;

    public Mesaj() {
    }

    public Mesaj(long cod) {
        this.cod = cod;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }
    
}
