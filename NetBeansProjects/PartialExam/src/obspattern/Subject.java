/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obspattern;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public interface Subject {
    public List<Observer> obs = new ArrayList<>();
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
