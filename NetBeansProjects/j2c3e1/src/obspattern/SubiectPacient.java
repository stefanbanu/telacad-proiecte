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
public interface SubiectPacient {
    ArrayList<PacientListener> obs2 = new ArrayList<>();
    public void addPacientListener(PacientListener p);
    public void notifica2();
}
