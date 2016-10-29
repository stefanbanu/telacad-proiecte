/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Stefan
 */
public class Client {
    
    static Registry registry;
    static InterfataRemote ir;
    
    public static void main(String[] args) throws Exception{
        registry = LocateRegistry.getRegistry("localhost", 4321);
        ir = (InterfataRemote) registry.lookup("server");
        ir.sayHello();
        int x = ir.suma(5, 19);
        System.out.println(x);
    }
}
