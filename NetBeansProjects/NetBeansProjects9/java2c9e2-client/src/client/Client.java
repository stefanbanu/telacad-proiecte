/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.IMyService;

/**
 *
 * @author student
 */
public class Client {
    private static Registry registry;
    private static IMyService myService;
    
    public static void main(String[] args) {
        try{
            registry = LocateRegistry.getRegistry("localhost", 4321);
            myService = (IMyService) registry.lookup("myService");
            System.out.println(myService.inversareSir("HELLO WORLD!"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
