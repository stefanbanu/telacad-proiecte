/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ProdusDTO;
import dto.Raspuns;
import dto.UserDTO;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.InterfaceProduse;
import rmi.InterfaceUsers;


/**
 *
 * @author Stefan
 */
public class ClientController {
    private Registry registry;
    private InterfaceUsers iu;
    private InterfaceProduse ip;
   
    private ClientController(){
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            iu = (InterfaceUsers) registry.lookup("myserver");
            ip = (InterfaceProduse) registry.lookup("myserver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final ClientController SINGLEZTON = new ClientController();
    }
    public static final ClientController getInstance(){
        return SingletonHolder.SINGLEZTON;
    }
    
    public List<ProdusDTO> getAllProducts(){
         List<ProdusDTO> l = null;
        try {
           l = ip.getAllProduse();
        } catch (RemoteException ex) {
            ex.printStackTrace();
             
        }
       return l;
    }
    public void adaugaProdus(String numeProdus){
        ProdusDTO p = new ProdusDTO();
        p.setNume(numeProdus);
        try {
            ip.adaugaProdus(p);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
      public void deleteProduct(ProdusDTO pDto){
    
        try {
            ip.stergeProdus(pDto);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public UserDTO login(String user, String pass){
        try {
            UserDTO u = new UserDTO();
            u.setUsername(user);
            u.setPassword(pass);
            
           return iu.login(u);
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
        return null;
    }
    
     public Raspuns register(String user, String pass){
         try {
            UserDTO u = new UserDTO();
            u.setUsername(user);
            u.setPassword(pass);
            
            return iu.register(u);
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }
}
