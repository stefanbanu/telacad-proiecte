package client.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import lib.dto.Comanda;
import lib.dto.MesajDTO;
import lib.dto.Raspuns;
import lib.dto.UserDTO;

public class ProxyController {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    private ProxyController(){
        try {
            socket = new Socket("localhost", 4321);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final ProxyController INSTANCE = new ProxyController();
    }
    
    public static ProxyController getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public Raspuns register(String username, String password) throws Exception {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        
        out.writeObject(new Comanda(Comanda.Cod.INREGISTRARE));
        out.writeObject(user);
        
        Raspuns r = (Raspuns) in.readObject();
        
        return r;
    }
    
    public UserDTO login(String username, String password) throws Exception {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        
        out.writeObject(new Comanda(Comanda.Cod.LOGIN));
        out.writeObject(user);
        
        UserDTO u = (UserDTO) in.readObject();
        
        return u;
    }
    
    public Raspuns adaugaMesaj(String text, UserDTO user) throws Exception {
        MesajDTO mesaj = new MesajDTO();
        mesaj.setMesaj(text);
        mesaj.setUser(user);
        
        out.writeObject(new Comanda(Comanda.Cod.ADDMESAJ));
        out.writeObject(mesaj);
        
        Raspuns r = (Raspuns) in.readObject();
        
        return r;
    }
    
    public List<MesajDTO> getMesaje(UserDTO user) throws Exception {
        out.writeObject(new Comanda(Comanda.Cod.GETMESAJE));
        out.writeObject(user);
        
        List<MesajDTO> listaMesaje = (List<MesajDTO>) in.readObject();
        
        return listaMesaje;
    }
}
