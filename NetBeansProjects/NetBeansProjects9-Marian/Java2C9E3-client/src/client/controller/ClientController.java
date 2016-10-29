package client.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import lib.dto.ProduseDto;
import lib.rmi.IProduseService;

public class ClientController {
    private Registry registry;
    private IProduseService server;
    
    private ClientController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4321);
            server = (IProduseService) registry.lookup("produseService");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final ClientController INSTANCE = new ClientController();
    }
    
    public static ClientController getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public void adaugaProdus(String nume) {
        try {
            ProduseDto produs = new ProduseDto();
            produs.setNume(nume);
            
            server.adaugaProdus(produs);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<ProduseDto> listaProduse() {
        try {
            return server.listaProduse();
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
