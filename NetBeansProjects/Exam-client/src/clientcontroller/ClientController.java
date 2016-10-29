/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcontroller;

import dto.PersoaneDTO;
import dto.Raspuns;
import dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import rmi.InterfacePersoane;
import rmi.InterfaceUsers;

/**
 *
 * @author Stefan
 */
public class ClientController {

    private Registry registry;
    private InterfaceUsers interfaceUsers;
    private InterfacePersoane interfacePersoane;

    private ClientController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            interfaceUsers = (InterfaceUsers) registry.lookup("myserver");
            interfacePersoane = (InterfacePersoane) registry.lookup("myserver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final class SingletonHolder {

        private static final ClientController SINGLETON = new ClientController();
    }

    public static final ClientController getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public Raspuns register(String user, String pass) {
        
        try {
            UserDTO uDto = new UserDTO();
            uDto.setUser(user);
            uDto.setParola(pass);

            Raspuns r = interfaceUsers.register(uDto);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public UserDTO login(String username, String password) {

        try {
            UserDTO uDto = new UserDTO();
            uDto.setUser(username);
            uDto.setParola(password);
            
            return interfaceUsers.login(uDto);
        } catch (Exception remoteException) {
            remoteException.printStackTrace(); 
        }
        return null;
    }
    
     public List<PersoaneDTO> listaPersoaneDto() {
        try {
            return interfacePersoane.listaPersoane();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
     
     public void adaugaPersoana(String nume, String prenume, String cnp){
         try {
             PersoaneDTO pdto = new PersoaneDTO();
             pdto.setNume(nume);
             pdto.setPrenume(prenume);
             pdto.setCnp(cnp);
             
             
             interfacePersoane.adaugaPersoana(pdto);
         } catch (Exception e) {
         }
     }
      public void stergePersoana(PersoaneDTO p){
         try {
             interfacePersoane.deletePersoana(p);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}
