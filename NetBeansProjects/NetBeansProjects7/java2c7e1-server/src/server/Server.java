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
            System.out.println("A fost deschis portul 4321");
            System.out.println("Se asteapta conectarea cu clientul.");
            Socket socket = ss.accept();
            System.out.println(
                    "Un client s-a conectat. "+
                            socket.getInetAddress().getHostAddress());
            try(
                InputStreamReader reader = 
                        new InputStreamReader(socket.getInputStream());
                BufferedReader in = new BufferedReader(reader);
                    
                PrintWriter out = 
                        new PrintWriter(socket.getOutputStream(), true);    
                ){
                String line = in.readLine();
                System.out.println("Am primit de la client : "+line);
                StringBuilder sb = new StringBuilder(line);
                sb.reverse();
                out.println(sb.toString());
                System.out.println("A fost trimis catre client sirul "+sb);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
