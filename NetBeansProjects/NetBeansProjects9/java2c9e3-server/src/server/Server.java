/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.service.ProductService;

/**
 *
 * @author student
 */
public class Server {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.createRegistry(4321);
            registry.rebind("productService", ProductService.getInstance());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
