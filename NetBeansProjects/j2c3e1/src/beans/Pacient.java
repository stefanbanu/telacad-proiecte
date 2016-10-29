/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Laur
 */
public class Pacient implements java.io.Serializable{
    private int id;
    private String nume,cnp;

    public Pacient() {
    }

    public Pacient(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public Pacient(int id, String nume, String cnp) {
        this.id = id;
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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
        return nume+" "+cnp;
    }
}
