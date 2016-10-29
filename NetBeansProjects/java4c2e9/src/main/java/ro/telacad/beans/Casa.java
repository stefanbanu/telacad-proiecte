/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author student
 */
@Component
public class Casa {
    
    @Autowired
    @Qualifier("badcat")
    private Pisica pisica;

    public Pisica getPisica() {
        return pisica;
    }

    public void setPisica(Pisica pisica) {
        this.pisica = pisica;
    }
    
    
}
