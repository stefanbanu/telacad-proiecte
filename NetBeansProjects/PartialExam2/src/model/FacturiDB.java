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
 * @author Stefan
 */
@Entity
@Table(name = "facturi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturiDB.findAll", query = "SELECT f FROM FacturiDB f"),
    @NamedQuery(name = "FacturiDB.findByIdFacturi", query = "SELECT f FROM FacturiDB f WHERE f.idFacturi = :idFacturi"),
    @NamedQuery(name = "FacturiDB.findBySerieFactura", query = "SELECT f FROM FacturiDB f WHERE f.serieFactura = :serieFactura"),
    @NamedQuery(name = "FacturiDB.findByNumarFactura", query = "SELECT f FROM FacturiDB f WHERE f.numarFactura = :numarFactura")})
public class FacturiDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFacturi")
    private Integer idFacturi;
    @Column(name = "serieFactura")
    private String serieFactura;
    @Column(name = "numarFactura")
    private String numarFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<Detaliifacturi> detaliifacturiCollection;

    public FacturiDB() {
    }

    public FacturiDB(Integer idFacturi) {
        this.idFacturi = idFacturi;
    }

    public Integer getIdFacturi() {
        return idFacturi;
    }

    public void setIdFacturi(Integer idFacturi) {
        this.idFacturi = idFacturi;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public String getNumarFactura() {
        return numarFactura;
    }

    public void setNumarFactura(String numarFactura) {
        this.numarFactura = numarFactura;
    }

    @XmlTransient
    public Collection<Detaliifacturi> getDetaliifacturiCollection() {
        return detaliifacturiCollection;
    }

    public void setDetaliifacturiCollection(Collection<Detaliifacturi> detaliifacturiCollection) {
        this.detaliifacturiCollection = detaliifacturiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturi != null ? idFacturi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturiDB)) {
            return false;
        }
        FacturiDB other = (FacturiDB) object;
        if ((this.idFacturi == null && other.idFacturi != null) || (this.idFacturi != null && !this.idFacturi.equals(other.idFacturi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Serie: " + serieFactura + " - " + "Numar: " + numarFactura;
    }
    
}
