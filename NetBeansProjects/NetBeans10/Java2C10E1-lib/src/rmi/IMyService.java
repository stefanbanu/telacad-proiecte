package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMyService extends Remote {
    public void sendMessage(String message) throws RemoteException;
}
