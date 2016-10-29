/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class ClientService implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ClientService(Socket socket) throws Exception{
        this.socket = socket;
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void sendMessage(String message){
        out.println(message);
    }
    
    @Override
    public void run() {
        try{
            while(true){
                Server.sendMessageToAll(in.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
