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
public interface SubiectUser {
    ArrayList<UserListener> obs = new ArrayList<UserListener>();
    public void addUserListener(UserListener ul);
    public void notifica();
}
