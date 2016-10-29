/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import rmi.IEvenNumbersService;

/**
 *
 * @author student
 */
public class EvenNumbersSumService extends UnicastRemoteObject 
                        implements IEvenNumbersService{
    
    public EvenNumbersSumService() throws RemoteException{
        
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
