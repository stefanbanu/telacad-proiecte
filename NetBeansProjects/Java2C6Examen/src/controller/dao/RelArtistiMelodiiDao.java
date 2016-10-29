package controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Artisti;
import model.Melodii;
import model.RelArtistiMelodii;

public class RelArtistiMelodiiDao {
    private EntityManager em;

    public RelArtistiMelodiiDao(EntityManager em) {
        this.em = em;
    }
    
    public void addMelodieArtist(RelArtistiMelodii relArtistiMelodii) {
        em.persist(relArtistiMelodii);
    }
}
