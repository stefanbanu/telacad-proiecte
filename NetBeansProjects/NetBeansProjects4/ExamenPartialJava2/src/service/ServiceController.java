/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import dao.ArtistiDao;
import dao.MelodiiDao;
import dao.UsersDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.ArtistiDB;
import model.MelodiiDB;
import model.UsersDB;

/**
 *
 * @author student
 */
public class ServiceController {
    private EntityManager em;
    private EntityManagerFactory emf;
    private UsersDao uDao;
    private ArtistiDao aDao;
    private MelodiiDao mDao;

    private ServiceController() {
        emf = Persistence.createEntityManagerFactory("ExamenPartialJava2PU");
        em = emf.createEntityManager();
        uDao = new UsersDao(em);
        aDao = new ArtistiDao(em);
        mDao = new MelodiiDao(em);
    }
    
    private static final class SingletonHolder{
        private static final ServiceController SINGLETON = new ServiceController();
    } 
    public static ServiceController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public UsersDB login(UsersDB u){
        
       
        List<UsersDB> useri =  uDao.getUsersByName(u);
        
        if (useri.size() > 0) {
            if (useri.get(0).getParola().equals(u.getParola())) {
                return useri.get(0);
            }else return null;
        }
        
        return null;
    }
    
    public List<ArtistiDB>  getAllArtisti(){
        
        List<ArtistiDB> artisti = aDao.getAllArtisti();
        
        return artisti;
        
    }
    
     public List<MelodiiDB>  getAllMelodii(ArtistiDB u){
        
        List<MelodiiDB> m = mDao.getAllMelodii(u);
        if(m.size() > 0){
            System.out.println(m);
        }
        
        return m;
        
    }
     public void adaugaUser(String user, String parola){
         em.getTransaction().begin();
         UsersDB u = new UsersDB(0, user, parola);
         uDao.addUser(u);
         em.getTransaction().commit();
     }
     
     public void deleteArtist(ArtistiDB u){
         em.getTransaction().begin();
         aDao.deleteArtist(u);
         em.getTransaction().commit();
     }
    
    
    
}
