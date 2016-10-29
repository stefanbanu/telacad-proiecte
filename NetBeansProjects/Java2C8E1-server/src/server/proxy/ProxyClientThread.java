package server.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import lib.dto.Comanda;
import lib.dto.MesajDTO;
import lib.dto.Raspuns;
import lib.dto.UserDTO;
import server.controller.service.MainService;

public class ProxyClientThread extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ProxyClientThread(Socket socket) throws IOException {
        this.socket = socket;
        // Se pune mai intai out si apoi in pt ca altfel nu se transmit datele pe anumite masini virtuale (Bug Java ??)
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                Comanda com = (Comanda) in.readObject();
                switch (com.getCod()) {
                    case INREGISTRARE: 
                        // Punem codul intr-un bloc de instructiuni pentru a putea utiliza mai jos in cod variabile cu aceleasi nume
                        {
                            UserDTO userDto = (UserDTO) in.readObject();
                            Raspuns ras = MainService.getInstance().register(userDto);
                            out.writeObject(ras);
                        }
                        break;
                    case LOGIN:
                        {
                            UserDTO userDto = (UserDTO) in.readObject();
                            UserDTO returnUser = MainService.getInstance().login(userDto);
                            out.writeObject(returnUser);
                        }
                        break;
                    case ADDMESAJ:
                        {
                            MesajDTO mesajDto = (MesajDTO) in.readObject();
                            Raspuns ras = MainService.getInstance().adaugaMesaj(mesajDto);
                            out.writeObject(ras);
                        }
                        break;
                    case GETMESAJE:
                        {
                            UserDTO userDto = (UserDTO) in.readObject();
                            List<MesajDTO> listaMesaje = MainService.getInstance().getMesaje(userDto);
                            out.writeObject(listaMesaje);
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
