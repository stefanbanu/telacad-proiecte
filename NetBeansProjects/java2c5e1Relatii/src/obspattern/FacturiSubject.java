/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obspattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public interface FacturiSubject {
    List<FacturiListener> LISTENERS = new ArrayList<>();
    
    default void addFacturaListner(FacturiListener fl){
        LISTENERS.add(fl);
    }
    
    default void removeFacturaListener(FacturiListener fl){
        LISTENERS.remove(fl);
    }
    
    default void notifyFacturiListeners(){
        for(FacturiListener fl: LISTENERS){
            fl.listaFacturiModificata();
        }
    }
}
