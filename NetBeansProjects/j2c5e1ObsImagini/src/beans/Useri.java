/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laur
 */
@Entity
@Table(name = "useri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useri.findAll", query = "SELECT u FROM Useri u"),
    @NamedQuery(name = "Useri.findById", query = "SELECT u FROM Useri u WHERE u.id = :id"),
    @NamedQuery(name = "Useri.findByNume", query = "SELECT u FROM Useri u WHERE u.nume = :nume"),
    @NamedQuery(name = "Useri.findByParola", query = "SELECT u FROM Useri u WHERE u.parola = :parola")
})
public class Useri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nume")
    private String nume;
    @Basic(optional = false)
    @Column(name = "parola")
    private String parola;

    public Useri() {
    }

    public Useri(Integer id) {
        this.id = id;
    }

    public Useri(Integer id, String nume, String parola) {
        this.id = id;
        this.nume = nume;
        this.parola = parola;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useri)) {
            return false;
        }
        Useri other = (Useri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Useri[ id=" + id + " ]";
    }
    
}
