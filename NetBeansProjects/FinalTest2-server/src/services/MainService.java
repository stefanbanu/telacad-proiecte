/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProdusDao;
import dao.UserDao;
import dto.ProdusDTO;
import dto.Raspuns;
import dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.ProduseDB;
import model.UsersDB;
import rmi.InterfaceProduse;
import rmi.InterfaceUsers;
import util.ProdusMapper;
import util.UsersMapper;

/**
 *
 * @author Stefan
 */
public class MainService extends UnicastRemoteObject implements InterfaceUsers, InterfaceProduse{
    private EntityManagerFactory emf;
    
    private MainService()throws RemoteException{
         emf = Persistence.createEntityManagerFactory("FinalTest2-serverPU");     
    }
    
     public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    @Override
    public void adaugaProdus(ProdusDTO p) throws RemoteException {
        EntityManager em = getEntityManager();        
        ProdusDao pDao = new ProdusDao(em);
        
        em.getTransaction().begin();
        pDao.adaugaProdus(ProdusMapper.convert(p));
        em.getTransaction().commit();
        
    }

    @Override
    public void stergeProdus(ProdusDTO p) throws RemoteException {
        EntityManager em = getEntityManager();        
        ProdusDao pDao = new ProdusDao(em);
        
       
         try {
             em.getTransaction().begin();
             pDao.stergeProdus(ProdusMapper.convert(p));
             em.getTransaction().commit();
        } finally{
            if (em != null) {
            em.close();
            }
        }
    }

    @Override
    public List<ProdusDTO> getAllProduse() throws RemoteException {
        EntityManager em = getEntityManager();        
        ProdusDao pDao = new ProdusDao(em);
        
        List<ProdusDTO> listPdto = new ArrayList<>();
        List<ProduseDB> listPdb = pDao.getListProduseDB();
        for (ProduseDB p : listPdb) {
            listPdto.add(ProdusMapper.convert(p));
        }
        return listPdto;
        
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
    
    public static final MainService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
     @Override
    public Raspuns register(UserDTO u) throws RemoteException {
        EntityManager em = getEntityManager();        
        UserDao uDao = new UserDao(em);
        
         try {
             UsersDB uDb =  uDao.findUserByName(u.getUsername());
             
             if(uDb == null){
                 uDb = new UsersDB();
                 uDb.setUsername(u.getUsername());
                 uDb.setPassword(u.getPassword());
                 
                 System.out.println(uDb.toString());
                 em.getTransaction().begin();
                 uDao.adaugaUser(uDb);
                 em.getTransaction().commit();
                 return new Raspuns(Raspuns.Cod.OK);
             }
             
         } catch (Exception e) {
             e.printStackTrace();
             em.getTransaction().rollback();
         }finally{
             if (em != null) {
                 em.close();
             }
         }
        
        return new Raspuns(Raspuns.Cod.NOTOK);
    }

    @Override
    public UserDTO login(UserDTO u) throws RemoteException {
         EntityManager em = getEntityManager();        
         UserDao uDao = new UserDao(em);
         
         UsersDB uDb = uDao.findUserByName(u.getUsername());
         if(uDb != null){
             if(uDb.getPassword().equals(u.getPassword())){
                 UserDTO uDto = UsersMapper.convert(uDb);
                 return uDto;
             }else return null;
         }else return null;
    }
}
