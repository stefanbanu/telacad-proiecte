/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib1.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Marian
 */
public interface IEvenNumberService extends Remote {
    int findEvenSum(List<Integer> numbers) throws RemoteException;
}
