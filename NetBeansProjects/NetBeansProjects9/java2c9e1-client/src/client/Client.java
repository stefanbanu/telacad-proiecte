/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.InterfataRemote;

/**
 *
 * @author student
 */
public class Client {
    private static Registry registry;
    private static InterfataRemote server;
    public static void main(String [] args){
        try{
            registry = LocateRegistry.getRegistry("localhost",4321);
            server = (InterfataRemote) registry.lookup("helloService");
            server.sayHello("Gigel");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
