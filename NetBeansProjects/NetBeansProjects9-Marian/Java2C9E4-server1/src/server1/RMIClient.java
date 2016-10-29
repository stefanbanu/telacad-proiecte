/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import lib2.rmi.ISumService;

/**
 *
 * @author Marian
 */
public class RMIClient {
    private Registry registry;
    private ISumService sumService;
    
    private RMIClient() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            sumService = (ISumService) registry.lookup("server2");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final RMIClient INSTANCE = new RMIClient();
    }
    
    public static RMIClient getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public int sum(List<Integer> numbers) throws RemoteException {
        return sumService.sum(numbers);
    }
}
