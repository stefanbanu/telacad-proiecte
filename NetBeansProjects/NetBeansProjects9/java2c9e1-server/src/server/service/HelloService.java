/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.InterfataRemote;

/**
 *
 * @author student
 */
public class HelloService extends UnicastRemoteObject 
    implements InterfataRemote{
    
    public HelloService() throws RemoteException{
        
    }

    @Override
    public void sayHello(String name) throws RemoteException {
        try {
            Thread.sleep(60*1000);
            System.out.println("Hello, "+name+"!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
