/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import rmi.IEvenNumbersService;

/**
 *
 * @author student
 */
public class Main {
    private static Registry registry;
    private static IEvenNumbersService evenNumbersService;
    public static void main(String [] args){
        try{
            Random r = new Random();
            registry = LocateRegistry.getRegistry("localhost", 4322);
            evenNumbersService = 
                    (IEvenNumbersService) registry.lookup("server1");
            Stream<Integer> stream = Stream.generate(() -> r.nextInt(1000));
            
            List<Integer> list = new ArrayList<>();
            stream.limit(30).forEach(list::add);
            System.out.println(evenNumbersService.findEvenSum(list));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
