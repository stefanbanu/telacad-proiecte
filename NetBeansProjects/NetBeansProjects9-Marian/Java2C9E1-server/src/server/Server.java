package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.service.HelloService;

public class Server {
    // Un registru este un tabel in care insemna ceva in dreptul cuiva.
    // O pereche "cheie / valoare", un nume (cheie) si un serviciu (valoare).
    // Aici vom trece serviciile pe care vrem sa le exportam.
    private static Registry registry;
    
    public static void main(String[] args) {
        try {
            registry = LocateRegistry.createRegistry(4321);
            // Rebind = Bind + unbind
            // Se inregistreaza o instanta in registru
            // Se poate adauga doar o metoda ce extinde UnicastRemoteObject
            registry.rebind("helloService", new HelloService());
            System.out.println("Server started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
