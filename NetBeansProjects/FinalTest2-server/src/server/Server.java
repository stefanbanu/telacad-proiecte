/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import services.MainService;

/**
 *
 * @author Stefan
 */
public class Server {
    private static Registry registry;
   
    public static void main(String[] args) throws RemoteException{
        try {
            registry = LocateRegistry.createRegistry(4321);
            registry.rebind("myserver", MainService.getInstance());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
}
