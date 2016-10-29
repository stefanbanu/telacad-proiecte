/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcontroller;

import dto.Comanda;
import dto.Raspuns;
import dto.UserDTO;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Stefan
 */
public class ProxyController {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private ProxyController(){
        try {
            socket = new Socket("localhost", 4321);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private static final class SingletonHolder {
        private static final ProxyController INSTANCE = new ProxyController();
    }
    
    public static ProxyController getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public Raspuns register(String username, String pass) throws Exception{
        UserDTO uDto = new UserDTO();
        uDto.setUsername(username);
        uDto.setPassword(pass);
        
        out.writeObject(new Comanda(Comanda.Cod.INREGISTRARE));
        out.writeObject(uDto);
        
        Raspuns r = (Raspuns) in.readObject();
        
        return r;
    }
}
