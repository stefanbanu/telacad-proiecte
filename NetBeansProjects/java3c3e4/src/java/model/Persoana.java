
package model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Persoana implements java.io.Serializable{
    private String nume;
    private String prenume;
    private int varsta;
    
    private List<Persoana> persoane;

    @PostConstruct
    private void init(){
        persoane = new ArrayList<>();
        persoane.add(createPersoana("Nume1", "Prenume1", 10));
        persoane.add(createPersoana("Nume2", "Prenume2", 15));
        persoane.add(createPersoana("Nume3", "Prenume3", 19));
        persoane.add(createPersoana("Nume4", "Prenume4", 16));
        persoane.add(createPersoana("Nume5", "Prenume5", 25));
        
    }
    
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public List<Persoana> getPersoane() {
        return persoane;
    }

    public void setPersoane(List<Persoana> persoane) {
        this.persoane = persoane;
    }
    
    private static Persoana createPersoana(String nume, String prenume, int varsta){
        Persoana p = new Persoana();
        p.setNume(nume);
        p.setPrenume(prenume);
        p.setVarsta(varsta);
        return p;
    }
}
