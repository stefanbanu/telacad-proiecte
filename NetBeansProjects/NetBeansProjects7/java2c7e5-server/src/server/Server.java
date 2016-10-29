/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author student
 */
public class Server {
    private static ServerSocket ss;
    private static List<ClientService> services = new ArrayList<>();
    private static Semaphore s = new Semaphore(1);
    public static void main(String[] args) {
        try{
            ss = new ServerSocket(4321);
            while(true){
                Socket socket = ss.accept();
                ClientService cs = new ClientService(socket);
                
                try{
                    s.acquire();
                    services.add(cs);
                }finally{
                    s.release();
                }
                
                new Thread(cs).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void sendMessageToAll(String message){
        try{
            s.acquire();
            services.parallelStream().forEach(c -> c.sendMessage(message));
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            s.release();
        }
    }
    
}
