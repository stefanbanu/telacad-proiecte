/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller.service;

import model.UsersDB;
import server.controller.dao.UsersDao;
import lib.dto.Raspuns;
import lib.dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lib.dto.ProduseDTO;
import lib.rmi.InterfaceProduse;
import lib.rmi.InterfaceUsers;
import model.ProduseDB;
import server.controller.dao.ProduseDao;
import util.ProdusMapper;
import util.UsersMapper;

/**
 *
 * @author Stefan
 */
public class ServiceProduse extends UnicastRemoteObject implements InterfaceProduse, InterfaceUsers{
    private EntityManagerFactory emf;
    
    private ServiceProduse() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("FinalTest-serverPU");
    }

    @Override
    public void adaugaProdus(ProduseDTO pDto) throws RemoteException {
         EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
        try {
            em.getTransaction().begin();
            produseDao.adaugaProdus(ProdusMapper.convert(pDto));
            em.getTransaction().commit();
        }  finally{
            if (em != null) {
            em.close();
            }
        } 
    }
    @Override
    public void deleteProdus(ProduseDTO pDto) throws RemoteException {
        EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
        try {
            em.getTransaction().begin();
            produseDao.stergeProd(ProdusMapper.convert(pDto));
            em.getTransaction().commit();
        } finally{
            if (em != null) {
            em.close();
            }
        }
    }
    

    @Override
    public List<ProduseDTO> listaProduse() throws RemoteException {
        EntityManager em = getEntityManager();
        ProduseDao produseDao = new ProduseDao(em);
        
        List<ProduseDTO> listaProduseDto = new ArrayList<>();
        List<ProduseDB> listaProduseDB = produseDao.findAll();
        
        for (ProduseDB p : listaProduseDB) {
            listaProduseDto.add(ProdusMapper.convert(p));
        }
        
        if (em != null) {
            em.close();
        }
        return listaProduseDto;
        
    }

    
    private static final class SingletonHolder {
        private static ServiceProduse SINGLETON;
        static {
            try {
                SINGLETON = new ServiceProduse();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }    
    }
    
    public static final ServiceProduse getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    @Override
     public Raspuns register(UserDTO uDto){

        EntityManager em = getEntityManager();
        UsersDao uDao = new UsersDao(em);
        
        try {
            UsersDB u = uDao.findUser(uDto.getUsername());
            
            if(u == null){
                u = new UsersDB();
                u.setUsername(uDto.getUsername());
                u.setPassword(uDto.getPassword());
                
                em.getTransaction().begin();
                uDao.adaugaUser(u);
                em.getTransaction().commit();
                return new Raspuns(Raspuns.Cod.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            if(em != null){
                em.close();
            }
        }
        
        return new Raspuns(Raspuns.Cod.NOTOK);
    }
     
      public UserDTO login(UserDTO u){
          EntityManager em = getEntityManager();
          UsersDao uDao = new UsersDao(em);
        List<UsersDB> list = uDao.getUseriByUser(u.getUsername());
        if(list.size()>0){
           if(list.get(0).getPassword().equals(u.getPassword())){
               UserDTO uDto = UsersMapper.convert(list.get(0));
               System.out.println(uDto.toString());
               return uDto;
           }else return null;
        }else return null;
    }
}
