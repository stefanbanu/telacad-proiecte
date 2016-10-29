/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Server {
    
    static ServerSocket ss;
    static ArrayList<ServerThread> clienti = new ArrayList<>();
 
    public static void main(String[] args) throws Exception{
        ss = new ServerSocket(4321);
        
        while (true) {            
           
           ServerThread st = new ServerThread(ss.accept());
           clienti.add(st);
           st.start();
            
        }
    }
    
}
