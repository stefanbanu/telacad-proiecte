/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import dto.PersoaneDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author student
 */
public interface InterfacePersoane extends Remote{
     void adaugaPersoana(PersoaneDTO pDto)throws RemoteException;
    List<PersoaneDTO>listaPersoane()throws RemoteException;

    public void deletePersoana(PersoaneDTO pDto)throws RemoteException;
    
}
