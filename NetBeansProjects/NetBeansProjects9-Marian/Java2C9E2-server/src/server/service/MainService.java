package server.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lib.rmi.IMainService;

public class MainService extends UnicastRemoteObject implements IMainService {

    public MainService() throws RemoteException {
    }

    @Override
    public String reverseText(String text) throws RemoteException {
        StringBuilder reversedText = new StringBuilder(text);
        reversedText.reverse();
        
        return reversedText.toString();
    }
    
}
