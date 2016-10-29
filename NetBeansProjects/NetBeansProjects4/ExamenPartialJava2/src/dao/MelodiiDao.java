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
import model.MelodiiDB;
import model.UsersDB;

/**
 *
 * @author student
 */
public class MelodiiDao {
    private EntityManager em;

    public MelodiiDao(EntityManager em) {
        this.em = em;
    }
    
    public List<MelodiiDB> getAllMelodii(ArtistiDB u) {
    //    Query q = em.createNamedQuery("MelodiiDB.findByNume");  
      
    Query q = em.createNativeQuery("select song_name from song "
                                 + "where id in(select song_id from artist_songs "
                                 + "where user_id in(select id from artist where artist_name='Michael Jackson')");

        q.setParameter("nume", u.getNume());
        return q.getResultList();
    }
}
