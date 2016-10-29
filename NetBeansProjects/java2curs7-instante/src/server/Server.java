/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;

/**
 *
 * @author Stefan
 */
public class Server {
    public static ServerSocket ss;
    
    public static void main(String[] args) throws Exception{
       ss = new ServerSocket(4321);
       
        while (true) {            
            new ServerThread(ss.accept()).start();
        }
    }
    
}
