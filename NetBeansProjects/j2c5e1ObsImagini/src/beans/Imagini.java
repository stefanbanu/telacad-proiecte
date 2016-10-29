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
@Table(name = "imagini")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagini.findAll", query = "SELECT i FROM Imagini i"),
    @NamedQuery(name = "Imagini.findById", query = "SELECT i FROM Imagini i WHERE i.id = :id"),
    @NamedQuery(name = "Imagini.findByUser", query = "SELECT i FROM Imagini i WHERE i.user = :user")})
public class Imagini implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "descriere")
    private String descriere;
    @Basic(optional = false)
    @Lob
    @Column(name = "imagine")
    private byte[] imagine;
    @Basic(optional = false)
    @Column(name = "user")
    private int user;

    public Imagini() {
    }

    public Imagini(Integer id) {
        this.id = id;
    }

    public Imagini(Integer id, String descriere, byte[] imagine, int user) {
        this.id = id;
        this.descriere = descriere;
        this.imagine = imagine;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public byte[] getImagine() {
        return imagine;
    }

    public void setImagine(byte[] imagine) {
        this.imagine = imagine;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
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
        if (!(object instanceof Imagini)) {
            return false;
        }
        Imagini other = (Imagini) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descriere;
    }
    
}
