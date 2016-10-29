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
@Table(name = "persoane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persoane.findAll", query = "SELECT p FROM Persoane p"),
    @NamedQuery(name = "Persoane.findById", query = "SELECT p FROM Persoane p WHERE p.id = :id")})
public class Persoane implements Serializable {
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
    @Column(name = "mail")
    private String mail;

    public Persoane() {
    }

    public Persoane(Integer id) {
        this.id = id;
    }

    public Persoane(Integer id, String nume, String mail) {
        this.id = id;
        this.nume = nume;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!(object instanceof Persoane)) {
            return false;
        }
        Persoane other = (Persoane) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nume+" "+mail;
    }
    
}
