package ro.marian.vicea.main;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pisica {
    private String nume;
    private String culoare;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
}