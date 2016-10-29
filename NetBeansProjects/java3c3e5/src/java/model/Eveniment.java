package model;

import java.util.Date;

/**
 *
 * @author student
 */
public class Eveniment implements java.io.Serializable{
    private String nume;
    private Date data;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
