package controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Artisti;

public class ArtistiDao {
    private EntityManager em;

    public ArtistiDao(EntityManager em) {
        this.em = em;
    }
    
    public List<Artisti> getAllArtisti() {
        Query q = em.createNamedQuery("Artisti.findAll");
        return q.getResultList();
    }
    
    public void removeArtist(Artisti artist) {
        em.remove(artist);
    }
}
