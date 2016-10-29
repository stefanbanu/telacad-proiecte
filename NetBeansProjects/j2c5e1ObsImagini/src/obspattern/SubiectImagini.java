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
public interface SubiectImagini {
    ArrayList<ImaginiListener> obs = new ArrayList<ImaginiListener>();
    public void addImaginiListener(ImaginiListener il);
    public void notificareImagini();
    
}
