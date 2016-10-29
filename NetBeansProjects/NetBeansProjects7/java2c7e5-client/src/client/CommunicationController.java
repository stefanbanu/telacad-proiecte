/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class CommunicationController {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    private CommunicationController(){
        try {
            socket = new Socket("localhost", 4321);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final CommunicationController SINGLETON = 
                new CommunicationController();
    } 
    
    public static CommunicationController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public String getMessage() throws IOException{
        return in.readLine();
    }
    
    public void sendMessage(String message){
        out.println(message);
    }
}
