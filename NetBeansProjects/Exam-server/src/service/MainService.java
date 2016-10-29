/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PersoaneDao;
import dao.UtilizatoriDao;
import dto.PersoaneDTO;
import dto.Raspuns;
import dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.PersoaneDB;
import model.UtilizatoriDB;
import rmi.InterfacePersoane;
import rmi.InterfaceUsers;
import util.PersoanaMapper;
import util.UsersMapper;

/**
 *
 * @author student
 */
public class MainService extends UnicastRemoteObject implements InterfaceUsers, InterfacePersoane {
    
    private EntityManagerFactory emf;
    
    private MainService() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("Exam-serverPU");
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    @Override
    public Raspuns register(UserDTO uDto) {
        EntityManager em = getEntityManager();
        UtilizatoriDao uDao = new UtilizatoriDao(em);

        try {
            UtilizatoriDB u = uDao.findUser(uDto.getUser());
            if (u == null) {
                u = new UtilizatoriDB();
                u.setUser(uDto.getUser());
                u.setParola(uDto.getParola());

                em.getTransaction().begin();
                uDao.adaugaUser(u);
                em.getTransaction().commit();
                return new Raspuns(Raspuns.Cod.OK);
            }
          } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }       
        return new Raspuns(Raspuns.Cod.NOTOK);
    }

    @Override
    public UserDTO login(UserDTO u) {
        EntityManager em = getEntityManager();
        UtilizatoriDao uDao = new UtilizatoriDao(em);
        List<UtilizatoriDB> list = uDao.getUseriByUser(u.getUser());
        if (list.size() > 0) {
            if (list.get(0).getParola().equals(u.getParola())) {
                UserDTO uDto = UsersMapper.convert(list.get(0));
                System.out.println(uDto.toString());
                return uDto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void adaugaPersoana(PersoaneDTO pDto) throws RemoteException {
         EntityManager em = getEntityManager();
        PersoaneDao persoaneDao = new PersoaneDao(em);
        
        try {
            em.getTransaction().begin();
            persoaneDao.adaugaPersoana(PersoanaMapper.convert(pDto));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PersoaneDTO> listaPersoane() throws RemoteException {
        EntityManager em = getEntityManager();
        PersoaneDao persoaneDao = new PersoaneDao(em);
        
        List<PersoaneDTO> listaPersoaneDto = new ArrayList<>();
        List<PersoaneDB> listaPersoaneDB = persoaneDao.findAll();
        
         for (PersoaneDB p : listaPersoaneDB) {
            listaPersoaneDto.add(PersoanaMapper.convert(p));
        }
        
        if (em != null) {
            em.close();
        }
        return listaPersoaneDto;
        
    }

    @Override
    public void deletePersoana(PersoaneDTO pDto) throws RemoteException {
        EntityManager em = getEntityManager();
        PersoaneDao persoaneDao = new PersoaneDao(em);
        
        try {
            em.getTransaction().begin();
            persoaneDao.stergePersoana(PersoanaMapper.convert(pDto));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final class SingletonHolder {

        private static MainService SINGLETON;

        static {
            try {
                SINGLETON = new MainService();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static final MainService getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
