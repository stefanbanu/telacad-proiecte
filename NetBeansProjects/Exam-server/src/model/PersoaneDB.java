/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "persoane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersoaneDB.findAll", query = "SELECT p FROM PersoaneDB p"),
    @NamedQuery(name = "PersoaneDB.findById", query = "SELECT p FROM PersoaneDB p WHERE p.id = :id"),
    @NamedQuery(name = "PersoaneDB.findByNume", query = "SELECT p FROM PersoaneDB p WHERE p.nume = :nume"),
    @NamedQuery(name = "PersoaneDB.findByPrenume", query = "SELECT p FROM PersoaneDB p WHERE p.prenume = :prenume"),
    @NamedQuery(name = "PersoaneDB.findByCnp", query = "SELECT p FROM PersoaneDB p WHERE p.cnp = :cnp")})
public class PersoaneDB implements Serializable {
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
    @Column(name = "prenume")
    private String prenume;
    @Basic(optional = false)
    @Column(name = "cnp")
    private String cnp;

    public PersoaneDB() {
    }

    public PersoaneDB(Integer id) {
        this.id = id;
    }

    public PersoaneDB(Integer id, String nume, String prenume, String cnp) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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
        if (!(object instanceof PersoaneDB)) {
            return false;
        }
        PersoaneDB other = (PersoaneDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PersoaneDB[ id=" + id + " ]";
    }
    
}
