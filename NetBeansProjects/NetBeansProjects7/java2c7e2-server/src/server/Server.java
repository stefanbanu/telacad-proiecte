/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class Server {

    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(4321);
            Socket socket = ss.accept();
            
            try(
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
                    PrintWriter out = 
                            new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader cons = new BufferedReader(
                            new InputStreamReader(System.in)
                    );
                    
               ){
                while(true){
                    
                    String line = in.readLine();
                    System.out.println("CLIENT: "+line);
                    System.out.print("MESAJ: ");
                    line = cons.readLine();
                    out.println(line);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
