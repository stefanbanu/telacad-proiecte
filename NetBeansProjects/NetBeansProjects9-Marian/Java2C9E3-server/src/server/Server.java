package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.controller.service.ProduseService;

public class Server {
    private static Registry registry;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.createRegistry(4321);
            registry.rebind("produseService", ProduseService.getInstance());
            System.out.println("Server started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
