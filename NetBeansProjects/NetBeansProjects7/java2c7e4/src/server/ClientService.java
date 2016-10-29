/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class ClientService implements Runnable{
    private boolean shouldStop;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ClientService(Socket socket) throws Exception{
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try{
            String username = null;
            String password = null;
            while(!shouldStop){
                username = in.readLine();
                password = in.readLine();
                out.println(login(username, password));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private String login(String username, String password){
        if(username.equals("gigel") && password.equals("12345")){
            return "OK";
        }else{
            return "NOT OK";
        }
    }
    
    public void stop(){
        this.shouldStop = true;
        System.out.println("STOPPING THREAD "+
                    Thread.currentThread().getName());
        Thread.currentThread().interrupt();
    }
}
