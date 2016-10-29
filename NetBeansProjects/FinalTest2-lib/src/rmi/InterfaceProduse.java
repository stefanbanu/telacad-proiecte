/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import dto.ProdusDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Stefan
 */
public interface InterfaceProduse extends Remote{
    public void adaugaProdus(ProdusDTO p)throws RemoteException;
    public void stergeProdus(ProdusDTO p) throws RemoteException;
    
    public List<ProdusDTO> getAllProduse()throws RemoteException;
}
