package lib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMainService extends Remote {
    String reverseText(String text) throws RemoteException;
}
