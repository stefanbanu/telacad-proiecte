/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server2.service.SumService;

/**
 *
 * @author Marian
 */
public class Server2 {
    private static Registry registry;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.createRegistry(4321);
            registry.rebind("server2", new SumService());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
