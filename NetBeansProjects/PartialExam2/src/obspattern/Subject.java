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
 * @author Stefan
 */
public interface Subject {
    List<Observer> obs = new ArrayList<>();
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}
