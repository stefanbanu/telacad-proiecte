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
public class ServerThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ServerThread(Socket socket) throws Exception{
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }
    
    @Override
    public void run(){
        try{
            while(true){
                String username = in.readLine();
                String parola = in.readLine();
                if(username.equals("gigel") && parola.equals("12345")){
                    out.println("ok");
                }else{
                    out.println("notok");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
