package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import rmi.IMyService;

public class ClientController {
    private Registry registry;
    private List<IMyService> services = new ArrayList<>();
    private int lastUsedService = 0;
    
    private ClientController() {
        try {
            for (int i = 4444; i < 4447; i++) {
                registry = LocateRegistry.getRegistry("localhost", i);
                services.add((IMyService) registry.lookup("server"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final ClientController INSTANCE = new ClientController();
    }
    
    public static ClientController getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    private IMyService getService() {
        if (lastUsedService == services.size()) {
            lastUsedService = 0;
        }
        
        return services.get(lastUsedService++);
    }
    
    public void sendMessage(String message) {
        try {
            getService().sendMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
