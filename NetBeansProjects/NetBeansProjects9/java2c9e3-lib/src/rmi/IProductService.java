/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import dto.ProductDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author student
 */
public interface IProductService extends Remote{
    public void adaugaProdus(ProductDTO produs) throws RemoteException;
    public List<ProductDTO> getAllProducts() throws RemoteException;
}
