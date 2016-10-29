/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "facturi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDB.findAll", query = "SELECT f FROM FacturaDB f"),
    @NamedQuery(name = "FacturaDB.findById", query = "SELECT f FROM FacturaDB f WHERE f.id = :id"),
    @NamedQuery(name = "FacturaDB.findBySerie", query = "SELECT f FROM FacturaDB f WHERE f.serie = :serie"),
    @NamedQuery(name = "FacturaDB.findByNumar", query = "SELECT f FROM FacturaDB f WHERE f.numar = :numar")})
public class FacturaDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "serie")
    private String serie;
    @Column(name = "numar")
    private String numar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<LinieFacturaDB> linieFacturaDBCollection;

    public FacturaDB() {
    }

    public FacturaDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    @XmlTransient
    public Collection<LinieFacturaDB> getLinieFacturaDBCollection() {
        return linieFacturaDBCollection;
    }

    public void setLinieFacturaDBCollection(Collection<LinieFacturaDB> linieFacturaDBCollection) {
        this.linieFacturaDBCollection = linieFacturaDBCollection;
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
        if (!(object instanceof FacturaDB)) {
            return false;
        }
        FacturaDB other = (FacturaDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura_id: " + id + "Serie: " + serie+" Numar: "+numar;
    }
    
}
