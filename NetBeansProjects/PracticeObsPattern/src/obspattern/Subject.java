/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obspattern;

import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public interface Subject {
    ArrayList<ProductListener> obs = new ArrayList<>(); 
    public void addProductListener(ProductListener pl);
    public void notifica();
}
