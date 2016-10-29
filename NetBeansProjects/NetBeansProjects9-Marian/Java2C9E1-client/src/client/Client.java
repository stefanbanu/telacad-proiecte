package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import lib.rmi.InterfataRemote;

public class Client {
    private static Registry registry;
    private static InterfataRemote server;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            server = (InterfataRemote) registry.lookup("helloService");
            // Apeleaza metoda de pe server printr-un PROXY facut cu ajutorul RMI
            server.sayHello("Gigel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
