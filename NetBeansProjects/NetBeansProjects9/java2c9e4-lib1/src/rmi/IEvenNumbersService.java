/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author student
 */
public interface IEvenNumbersService extends Remote{
    public int findEvenSum(List<Integer> numbers) throws RemoteException;
}
