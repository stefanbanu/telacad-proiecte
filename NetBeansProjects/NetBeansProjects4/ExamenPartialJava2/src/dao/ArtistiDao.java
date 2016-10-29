/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ArtistiDB;

/**
 *
 * @author student
 */
public class ArtistiDao {
    private EntityManager em;

    public ArtistiDao(EntityManager em) {
        this.em = em;
    }

    public List<ArtistiDB> getAllArtisti() {
        Query q = em.createNamedQuery("ArtistiDB.findAll");       
        return q.getResultList();
    }

    public void deleteArtist(ArtistiDB u) {
        em.remove(u);
    }
    
     
    
    
}
