/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class Server {

    public static void main(String[] args) {
        try{
            ServerSocket ss=  new ServerSocket(4321);
            while(true){
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
