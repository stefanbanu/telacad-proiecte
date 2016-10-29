/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.controllers;

import dto.ProductDTO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.IProductService;

/**
 *
 * @author student
 */
public class ClientController {
    private Registry registry;
    private IProductService productService;
    
    private ClientController(){
        try{
        registry = LocateRegistry.getRegistry("localhost",4321);
        productService = (IProductService) registry.lookup("productService");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ClientController SINGELTON = 
                new ClientController();
    }
    
    public static ClientController getInstance(){
        return SingletonHolder.SINGELTON;
    }
    
    public void adaugaProdus(String nume){
        try {
            ProductDTO product = new ProductDTO();
            product.setNume(nume);
            productService.adaugaProdus(product);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<ProductDTO> getProducts(){
        try {
            return productService.getAllProducts();
        } catch (RemoteException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}
