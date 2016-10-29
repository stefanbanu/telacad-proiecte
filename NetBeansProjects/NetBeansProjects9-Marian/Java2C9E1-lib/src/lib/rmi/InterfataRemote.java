package lib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfataRemote extends Remote {
    // Toate metodele dintr-o interfata Remote trebuie sa arunce exceptie de tipul RemoteException
    // Altfel va arunca o exceptie la compilare
    void sayHello(String name) throws RemoteException;
}
