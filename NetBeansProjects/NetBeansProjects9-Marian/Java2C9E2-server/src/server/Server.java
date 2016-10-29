package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.service.MainService;

public class Server {
    private static Registry registry;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.createRegistry(4321);
            registry.rebind("mainService", new MainService());
            System.out.println("Server started!");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
