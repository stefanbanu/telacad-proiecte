/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.service.HelloService;

/**
 *
 * @author student
 */
public class Server {
    private static Registry registry;
    public static void main(String[] args) {
       try{
           registry = LocateRegistry.createRegistry(4321);
           registry.rebind("helloService", new HelloService());
           System.out.println("Server started!");
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
}
