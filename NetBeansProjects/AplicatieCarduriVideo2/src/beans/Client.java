
package beans;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Client implements Serializable{
    
    private int id;
    private String nume, prenume;

    public Client() {
    }

    public Client(String nume, String prenume) {
        
        this.nume = nume;
        this.prenume = prenume;
    }

    public Client(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

//    @Override
//    public String toString() {
//        return "Client{" + "id=" + id + ", nume=" + nume + ", prenume=" + prenume + '}';
//    }

    @Override
    public String toString(){
        return nume + " " + prenume; 
    }
    
}
