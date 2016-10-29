/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Laur
 */
public class Persoana implements java.io.Serializable{
    
    private int id;
    private String nume;

    public Persoana() {
    }

    public Persoana(String nume) {
        this.nume = nume;
    }

    public Persoana(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    
    public String toString(){
        return nume;
    }
    
}
