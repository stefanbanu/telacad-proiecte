/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import lib.dto.ProduseDTO;
import lib.dto.Raspuns;
import lib.dto.UserDTO;

/**
 *
 * @author Stefan
 */
public interface InterfaceProduse extends Remote{
    void adaugaProdus(ProduseDTO pDto)throws RemoteException;
    List<ProduseDTO>listaProduse()throws RemoteException;

    public void deleteProdus(ProduseDTO pDto)throws RemoteException;
    
}
