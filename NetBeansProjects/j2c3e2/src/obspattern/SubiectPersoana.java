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
public interface SubiectPersoana {
    ArrayList<PersoanaListener> obs =new ArrayList<PersoanaListener>(); 
    public void addPersoanaListener(PersoanaListener p);
    public void notifica();
}
