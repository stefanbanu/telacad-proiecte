/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.IMyService;

/**
 *
 * @author student
 */
public class MyService extends UnicastRemoteObject implements IMyService{

    public MyService() throws RemoteException{
        
    }
    
    @Override
    public String inversareSir(String sir) throws RemoteException {
       StringBuilder sb = new StringBuilder(sir);
       return sb.reverse().toString();
    }
    
}
