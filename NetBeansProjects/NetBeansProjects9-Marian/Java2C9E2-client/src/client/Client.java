package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import lib.rmi.IMainService;

public class Client {
    private static Registry registry;
    private static IMainService server;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            server = (IMainService) registry.lookup("mainService");
            String reversedString = server.reverseText("abcd");
            System.out.println(reversedString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
