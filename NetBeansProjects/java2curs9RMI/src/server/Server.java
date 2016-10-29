/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Stefan
 */
public class Server extends UnicastRemoteObject implements InterfataRemote{

    private Registry registry;
    
    public Server() throws RemoteException {
        registry = LocateRegistry.createRegistry(4321);
        registry.rebind("server", this);
    }
    
    

    public static void main(String[] args) throws Exception{
        Server s = new Server();
    }

    @Override
    public void sayHello() throws RemoteException {
        System.out.println("Hello World!");
    }

    @Override
    public int suma(int a, int b) {
      
        return a+b;
    }
    
    
}
