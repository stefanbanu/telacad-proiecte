/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.Mesaj;
import beans.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import utils.MesajConstants;

/**
 *
 * @author Stefan
 */
public class ServerThread extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    

    public ServerThread(Socket socket) throws Exception {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                User u = (User) in.readObject();
                if (u.getUsername().equals("gigel") && u.getPassword().equals("12345")) {
                    out.writeObject(new Mesaj(MesajConstants.LOGIN_EFECTUAT));
                }else {
                    out.writeObject(new Mesaj(MesajConstants.LOGIN_ESUAT));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
