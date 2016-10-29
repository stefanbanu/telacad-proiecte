package client.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import lib.dto.ProduseDto;
import lib.rmi.IProduseService;

public class ClientController {
    private Registry registry;
    private IProduseService service;
    
    private ClientController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4444);
            service = (IProduseService) registry.lookup("server");
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
    
    public void addProduct(String nume) {
        try {
            ProduseDto produs = new ProduseDto();
            produs.setNume(nume);
            
            service.adaugaProdus(produs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void deleteProduct(String nume) {
        try {
            ProduseDto produs = new ProduseDto();
            produs.setNume(nume);
            
            service.deleteProdus(produs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
