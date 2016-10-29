/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import dto.Raspuns;
import java.rmi.Remote;
import java.rmi.RemoteException;
import dto.UserDTO;

/**
 *
 * @author Stefan
 */
public interface InterfaceUsers extends Remote{
    public Raspuns register(UserDTO uDto)throws RemoteException;
    public UserDTO login(UserDTO uDto)throws RemoteException;
}
