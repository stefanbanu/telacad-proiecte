package lib.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import lib.dto.ProduseDto;

public interface IProduseService extends Remote {
    void adaugaProdus(ProduseDto produse) throws RemoteException;
    void deleteProdus(ProduseDto produse) throws RemoteException;
    List<ProduseDto> listaProduse() throws RemoteException;
}
