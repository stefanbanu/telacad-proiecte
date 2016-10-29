/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server1.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import lib1.rmi.IEvenNumberService;
import server1.RMIClient;

/**
 *
 * @author Marian
 */
public class EvenNumberSumService extends UnicastRemoteObject implements IEvenNumberService {
    public EvenNumberSumService() throws RemoteException {
    }

    @Override
    public int findEvenSum(List<Integer> numbers) throws RemoteException {
        List<Integer> evenNumbers = new ArrayList<>();
        numbers.stream()
                .filter(x -> x%2 == 0)
                .forEach(evenNumbers::add);
        
        return RMIClient.getInstance().sum(evenNumbers);
    }
    
}
