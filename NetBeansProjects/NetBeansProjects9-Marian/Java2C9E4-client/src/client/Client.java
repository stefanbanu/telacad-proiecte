package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import lib1.rmi.IEvenNumberService;

public class Client {
    private static Registry registry;
    private static IEvenNumberService evenNumberService;

    public static void main(String[] args) {
        try {
            Random r = new Random();
            registry = LocateRegistry.getRegistry("localhost", 4322);
            evenNumberService = (IEvenNumberService) registry.lookup("server1");
            
            List<Integer> list = new ArrayList<>();
            
            Stream<Integer> stream = Stream.generate(() -> r.nextInt(1000));
            stream.limit(30).forEach(list::add);
            
            System.out.println(evenNumberService.findEvenSum(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
