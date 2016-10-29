package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lib.rmi.InterfataRemote;

public class HelloService extends UnicastRemoteObject implements InterfataRemote {

    public HelloService() throws RemoteException {}

    // RMI-ul va implementa la randul lui metoda pe client exact cum e scrisa aici (??)
    @Override
    public void sayHello(String name) throws RemoteException {
        System.out.println("Hello, " + name + "!");
    }
    
}
