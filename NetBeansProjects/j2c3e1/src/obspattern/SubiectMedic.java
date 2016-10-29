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
public interface SubiectMedic {
    ArrayList<MedicListener> obs = new ArrayList<MedicListener>();
    public void addMedicListener(MedicListener ml);
    public void notifica();
}
