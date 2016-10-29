/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import dto.Raspuns;
import dto.UserDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Stefan
 */
public interface InterfaceUsers extends Remote{
    public Raspuns register(UserDTO u)throws RemoteException;
    public UserDTO login(UserDTO u)throws RemoteException;
}
