/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server2.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lib2.rmi.ISumService;

/**
 *
 * @author Marian
 */
public class SumService extends UnicastRemoteObject implements ISumService {

    public SumService() throws RemoteException {
    }

    @Override
    public int sum(List<Integer> list) throws RemoteException {
        return list.stream().reduce(0, (a,b) -> a+b);
    }

}