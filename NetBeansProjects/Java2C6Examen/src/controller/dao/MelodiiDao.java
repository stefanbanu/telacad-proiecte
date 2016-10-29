package controller.dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Artisti;
import model.Melodii;
import model.RelArtistiMelodii;

public class MelodiiDao {
    private EntityManager em;

    public MelodiiDao(EntityManager em) {
        this.em = em;
    }
    
    public int addMelodie(Melodii melodie) {
        em.persist(melodie);
        em.flush();
        
        return melodie.getId();
    }
    
    public int removeMelodiiByArtist(Artisti artist) {
        Query q = em.createNativeQuery("DELETE m.* FROM melodii m LEFT JOIN rel_artisti_melodii rel ON m.id = rel.fk_melodii WHERE rel.fk_artisti = ?");
        q.setParameter(1, artist.getId());
        
        return q.executeUpdate();
    }
    
    public List<Melodii> getAllMelodiiByArtisti(Artisti artist) {
        Query q = em.createNativeQuery("SELECT m.* FROM melodii m LEFT JOIN rel_artisti_melodii rel ON m.id = rel.fk_melodii WHERE rel.fk_artisti = ?", Melodii.class);
        q.setParameter(1, artist.getId());
        
        return q.getResultList();
    }
}
