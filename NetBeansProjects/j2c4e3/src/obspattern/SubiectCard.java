/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obspattern;

import beans.Carduri;
import java.util.ArrayList;

/**
 *
 * @author Laur
 */
public interface SubiectCard {
    ArrayList<CardListener> obs = new ArrayList<CardListener>();
    public void addCardListener(CardListener cl);
    public void notifica(Carduri c);
}
