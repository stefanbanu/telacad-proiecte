package lib.dto;

public class Raspuns implements java.io.Serializable {
    private Cod cod;
    
    public static enum Cod implements java.io.Serializable {
        OK, NOTOK
    }
    
    public Raspuns(Cod cod) {
        this.cod = cod;
    }
    
    public Cod getCod() {
        return this.cod;
    }
}
