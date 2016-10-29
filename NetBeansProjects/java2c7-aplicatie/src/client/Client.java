/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.MainFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class Client {
    private static Socket socket;
    public static BufferedReader in;
    public static PrintWriter out;
    public static String nume;
 
    public static void main(String args[]) throws Exception{
   
            System.out.println("fds");
            String ip = JOptionPane.showInputDialog("Server Address: ");
            nume = JOptionPane.showInputDialog("Name: ");
            
            socket = new Socket(ip, 4321);
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    
                    new MainFrame().setVisible(true);
                    
                }
            });
    
    }
}
