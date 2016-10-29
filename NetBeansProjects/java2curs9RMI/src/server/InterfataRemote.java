/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Stefan
 */
public interface InterfataRemote extends Remote{
    public void sayHello() throws RemoteException;
    public int suma(int a, int b) throws RemoteException;
}
