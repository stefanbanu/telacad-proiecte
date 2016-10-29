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
            System.out.println("Client conectat la server");
            
            try(
                InputStreamReader reader = 
                        new InputStreamReader(socket.getInputStream());
                BufferedReader in = new BufferedReader(reader);
                PrintWriter out = 
                        new PrintWriter(socket.getOutputStream(),true);
                ){
                
                out.println("ANA ARE MERE!");
                String line = in.readLine();
                System.out.println("AM PRIMIT DE LA SERVER "+line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
