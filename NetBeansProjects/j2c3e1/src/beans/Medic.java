/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Laur
 */
public class Medic {
    private int id;
    private String nume,serie;

    public Medic() {
    }

    public Medic(String nume, String serie) {
        this.nume = nume;
        this.serie = serie;
    }

    public Medic(int id, String nume, String serie) {
        this.id = id;
        this.nume = nume;
        this.serie = serie;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    public String toString(){
        return nume;
    }
}
