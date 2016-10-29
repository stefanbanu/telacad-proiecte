/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Useri;
import obspattern.SubiectUseri;
import obspattern.UseriListener;

/**
 *
 * @author Stefan
 */
public class UserService implements SubiectUseri{

    private EntityManagerFactory emf;
    private EntityManager em;
    private UserDao userDao;

    private UserService() {
        emf = Persistence.createEntityManagerFactory("AplicationTestExamPU");
        em = emf.createEntityManager();
        userDao = new UserDao(em);
    }

    private static final class SingletonHolder {

        private static final UserService SINGLETON = new UserService();
    }

    public static UserService getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public void adaugaUser(String user, String parola) {
        em.getTransaction().begin();
        Useri u = new Useri();
        u.setUser(user);
        u.setParola(parola);
        userDao.adaugaUser(u);
        em.getTransaction().commit();
        notifica();
    }

    public void stergeUser(Useri u) {
        em.getTransaction().begin();
        userDao.stergeUser(u);
        em.getTransaction().commit();
        notifica();
    }

    public void modificaUser(Useri u) {
        em.getTransaction().begin();
        userDao.modificaUser(u);
        em.getTransaction().commit();
    }

    public List<Useri> getAllUsers() {
        return userDao.getAllUsers();
    }

    public Useri login(Useri u) {
        List<Useri> useri = userDao.findUserByUsername(u.getUser());
        if (useri.size() > 0) {
            if (useri.get(0).getParola().equals(u.getParola())) {
                return useri.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
      @Override
    public void addUseriListener(UseriListener pl) {
        obs.add(pl);
    }

    @Override
    public void notifica() {
        for (UseriListener ob : obs) {
            ob.userModificat();
        }
    }
}
