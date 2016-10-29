/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import lib.dto.Raspuns;
import lib.dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import lib.dto.ProduseDTO;
import lib.rmi.InterfaceProduse;
import lib.rmi.InterfaceUsers;

/**
 *
 * @author Stefan
 */
public class ClientController {

    private Registry registry;
    private InterfaceProduse interfaceProduse;
    private InterfaceUsers interfaceUsers;

    private ClientController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            interfaceProduse = (InterfaceProduse) registry.lookup("myServer");
            interfaceUsers = (InterfaceUsers) registry.lookup("myServer");
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

    public void adaugaProdus(String numeProdus) {
        try {
            ProduseDTO pDto = new ProduseDTO();
            pDto.setNume(numeProdus);

            interfaceProduse.adaugaProdus(pDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stergeProdus(ProduseDTO pDto) {
        try {
            interfaceProduse.deleteProdus(pDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProduseDTO> listaProduseDto() {
        try {
            return interfaceProduse.listaProduse();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Raspuns register(String user, String pass) {
        try {
            UserDTO uDto = new UserDTO();
            uDto.setUsername(user);
            uDto.setPassword(pass);

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
            uDto.setUsername(username);
            uDto.setPassword(password);
            
            return interfaceUsers.login(uDto);
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace(); 
        }
        return null;
    }
}
