package server1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server1.service.EvenNumberSumService;

public class Server1 {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(4322);
            registry.rebind("server1", new EvenNumberSumService());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
