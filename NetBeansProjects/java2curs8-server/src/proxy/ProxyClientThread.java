/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import controller.service.MainService;
import dto.Comanda;
import dto.Raspuns;
import dto.UserDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Stefan
 */
public class ProxyClientThread extends Thread{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ProxyClientThread(Socket socket) throws IOException{
        this.socket = socket;
        
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {                
                Comanda com = (Comanda) in.readObject();
                switch(com.getCod()){
                    case INREGISTRARE:
                    {
                        UserDTO userDto = (UserDTO) in.readObject();
                        Raspuns r = MainService.getInstance().register(userDto);
                        out.writeObject(r);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    
}
