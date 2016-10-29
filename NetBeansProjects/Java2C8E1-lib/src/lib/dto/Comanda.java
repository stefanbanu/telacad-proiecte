package lib.dto;

// Clasa defineste ce operatii cere clientul serverului
public class Comanda implements java.io.Serializable {
    private Cod cod;
    
    public static enum Cod implements java.io.Serializable {
        INREGISTRARE,
        LOGIN,
        ADDMESAJ,
        GETMESAJE
    }
    
    public Comanda (Cod cod) {
        this.cod = cod;
    }
    
    public Cod getCod() {
        return this.cod;
    }
}
