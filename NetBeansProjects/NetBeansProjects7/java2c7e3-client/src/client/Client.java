/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class Client {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",4321);
            
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
                    System.out.print("USERNAME:");
                    String username = cons.readLine();
                    System.out.print("PAROLA:");
                    String parola = cons.readLine();
                    out.println(username);
                    out.println(parola);
                    String response = in.readLine();
                    System.out.println(response);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
