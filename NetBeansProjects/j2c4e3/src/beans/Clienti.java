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
@Table(name = "clienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienti.findAll", query = "SELECT c FROM Clienti c"),
    @NamedQuery(name = "Clienti.findById", query = "SELECT c FROM Clienti c WHERE c.id = :id")})
public class Clienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "nume")
    private String nume;
    @Basic(optional = false)
    @Lob
    @Column(name = "prenume")
    private String prenume;

    public Clienti() {
    }

    public Clienti(Integer id) {
        this.id = id;
    }

    public Clienti(Integer id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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
        if (!(object instanceof Clienti)) {
            return false;
        }
        Clienti other = (Clienti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nume+" "+prenume;
    }
    
}
