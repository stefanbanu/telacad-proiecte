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
public interface SubiectUseri {
    ArrayList<UseriListener> obs = new ArrayList<UseriListener>();
    public void addUseriListener(UseriListener ul);
    public void notifica();
}
