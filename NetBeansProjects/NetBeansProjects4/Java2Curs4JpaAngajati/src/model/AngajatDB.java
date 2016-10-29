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
@Table(name = "angajati")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AngajatDB.findAll", query = "SELECT a FROM AngajatDB a"),
    @NamedQuery(name = "AngajatDB.findById", query = "SELECT a FROM AngajatDB a WHERE a.id = :id"),
    @NamedQuery(name = "AngajatDB.findByNume", query = "SELECT a FROM AngajatDB a WHERE a.nume = :nume"),
    @NamedQuery(name = "AngajatDB.findByPrenume", query = "SELECT a FROM AngajatDB a WHERE a.prenume = :prenume")})
public class AngajatDB implements Serializable {
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

    public AngajatDB() {
    }

    public AngajatDB(Integer id) {
        this.id = id;
    }

    public AngajatDB(Integer id, String nume, String prenume) {
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
        if (!(object instanceof AngajatDB)) {
            return false;
        }
        AngajatDB other = (AngajatDB) object;
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
