package controller.service;

import controller.dao.ArtistiDao;
import controller.dao.MelodiiDao;
import controller.dao.RelArtistiMelodiiDao;
import java.util.List;
import javax.persistence.EntityManager;
import model.Artisti;
import model.Melodii;
import model.RelArtistiMelodii;
import tx.TransactionManager;

public class MainService {
    private EntityManager em;
    private ArtistiDao artistiDao;
    private MelodiiDao melodiiDao;
    private RelArtistiMelodiiDao relArtistiMelodiiDao;

    private MainService() {
        em = TransactionManager.getInstance().getEntityManager();
        artistiDao = new ArtistiDao(em);
        melodiiDao = new MelodiiDao(em);
        relArtistiMelodiiDao = new RelArtistiMelodiiDao(em);
    }
    
    private static final class SingletonHolder {
        private static final MainService INSTANCE = new MainService();
    }
    
    public static MainService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public List<Artisti> getAllArtisti() {
        return artistiDao.getAllArtisti();
    }
    
    public void removeArtist(Artisti artist) {
        try {
            TransactionManager.getInstance().startTransaction();
            
            melodiiDao.removeMelodiiByArtist(artist);
            artistiDao.removeArtist(artist);
            
            TransactionManager.getInstance().commit();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionManager.getInstance().rollback();
        }
    }
    
    public void addMelodie(String numeMelodie, String gen, Artisti artist) {
        try {
            TransactionManager.getInstance().startTransaction();
            
            Melodii melodie = new Melodii(null, numeMelodie, gen);
            //melodie.setRelArtistiMelodiiCollection(new List().add(artist));
            int idMelodie = melodiiDao.addMelodie(melodie);
            melodie.setId(idMelodie);
            
            RelArtistiMelodii relArtistiMelodii = new RelArtistiMelodii();
            relArtistiMelodii.setFkMelodii(melodie);
            relArtistiMelodii.setFkArtisti(artist);
            relArtistiMelodiiDao.addMelodieArtist(relArtistiMelodii);
            
            TransactionManager.getInstance().commit();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionManager.getInstance().rollback();
        }
    }
    
    public List<Melodii> getAllMelodiiArtist(Artisti artist) {
        return melodiiDao.getAllMelodiiByArtisti(artist);
    }
}
