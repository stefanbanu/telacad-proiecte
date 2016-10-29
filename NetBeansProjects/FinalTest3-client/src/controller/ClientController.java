/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.InterfaceUsers;

/**
 *
 * @author Stefan
 */
public class ClientController {
    
   private Registry reg;
   private InterfaceUsers iu;
   
    private ClientController(){
        try {
            reg = LocateRegistry.getRegistry("localhost", 4321);
            iu = (InterfaceUsers) reg.lookup("myserver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static final class SingletonHolder{
        private static ClientController SINGLETON;
        static{
            try {
                SINGLETON = new ClientController();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static final ClientController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    public void test(){
        try {
            iu.getTest();
        } catch (RemoteException r) {
            r.printStackTrace();
        }
    }
}
