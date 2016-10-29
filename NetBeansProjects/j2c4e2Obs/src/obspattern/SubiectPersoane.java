/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obspattern;

import java.util.ArrayList;

/**
 *
 * @author Laur
 */
public interface SubiectPersoane {
    ArrayList<PersoaneListener> obs = new ArrayList<PersoaneListener>();
    public void addPersoaneListener(PersoaneListener pl);
    public void notifica();
}
