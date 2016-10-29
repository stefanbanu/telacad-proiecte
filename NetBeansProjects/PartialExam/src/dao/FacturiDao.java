/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
public class FacturiDao {
    private EntityManager em;

    public FacturiDao(EntityManager em) {
        this.em = em;
    }
    
    
}
