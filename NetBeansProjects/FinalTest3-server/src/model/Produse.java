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
 * @author Stefan
 */
@Entity
@Table(name = "produse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produse.findAll", query = "SELECT p FROM Produse p"),
    @NamedQuery(name = "Produse.findById", query = "SELECT p FROM Produse p WHERE p.id = :id"),
    @NamedQuery(name = "Produse.findByProdus", query = "SELECT p FROM Produse p WHERE p.produs = :produs")})
public class Produse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "produs")
    private String produs;

    public Produse() {
    }

    public Produse(Integer id) {
        this.id = id;
    }

    public Produse(Integer id, String produs) {
        this.id = id;
        this.produs = produs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdus() {
        return produs;
    }

    public void setProdus(String produs) {
        this.produs = produs;
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
        if (!(object instanceof Produse)) {
            return false;
        }
        Produse other = (Produse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produse[ id=" + id + " ]";
    }
    
}
