package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.IMyService;

public class Server extends UnicastRemoteObject implements IMyService {
    private Registry registry;
    
    public Server() throws RemoteException {
        registry = LocateRegistry.createRegistry(4446);
        registry.rebind("server", this);
    }
    
    public static void main(String[] args) {
        try {
            new Server();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println(message);
    }
    
}
