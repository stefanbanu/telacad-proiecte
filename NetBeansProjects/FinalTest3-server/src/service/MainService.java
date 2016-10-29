/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.InterfaceUsers;

/**
 *
 * @author Stefan
 */
public class MainService extends UnicastRemoteObject implements InterfaceUsers{
    
    private MainService()throws RemoteException{
        
    }
    
    private static final class SingletonHolder{
        private static MainService SINGLETON;
        static {
            try {
                SINGLETON = new MainService();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static final MainService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    public void getTest(){
        System.out.println("test from Main service");
    }
}
