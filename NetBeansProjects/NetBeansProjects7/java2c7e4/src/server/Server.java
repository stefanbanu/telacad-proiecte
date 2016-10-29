/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author student
 */
public class Server {
    private static ServerSocket ss;
    private static BufferedReader cons;
    
    private static ExecutorService service;
    private static ExecutorService listenerExecutorService;
    
    private static List<Future<?>> clientServiceFutures = 
            new ArrayList<>();
    
    public static void main(String[] args) {
        try{
            ss = new ServerSocket(4321);
            cons = new BufferedReader(new InputStreamReader(System.in));
            
            service = Executors.newWorkStealingPool();
            listenerExecutorService = Executors.newSingleThreadExecutor();
            
            ClientListener clientListener = new ClientListener();
            Future<?> clf = listenerExecutorService.submit(clientListener);
            
            
            String cmd = null;
            
            System.out.println("BEFORE EXIT");
            while(!"exit".equals(cmd)){
                cmd = cons.readLine();
            }
            System.out.println("AFTER EXIT");
            
            clf.cancel(true);
            for(Future<?> cs: clientServiceFutures){
                cs.cancel(true);
            }
            
            listenerExecutorService.shutdownNow();
            service.shutdownNow();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static class ClientListener implements Runnable{

        @Override
        public void run(){
            try{
                while(true){
                    Socket socket = ss.accept();
                    ClientService cs = new ClientService(socket);
                    Future<?> f =  service.submit(cs);
                    clientServiceFutures.add(f);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        public void stop(){
            System.out.println("STOPPING THREAD "+
                    Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
    
}
