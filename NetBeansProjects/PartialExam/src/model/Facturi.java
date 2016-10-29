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
    @NamedQuery(name = "Facturi.findAll", query = "SELECT f FROM Facturi f"),
    @NamedQuery(name = "Facturi.findById", query = "SELECT f FROM Facturi f WHERE f.id = :id"),
    @NamedQuery(name = "Facturi.findByFacturaSerie", query = "SELECT f FROM Facturi f WHERE f.facturaSerie = :facturaSerie"),
    @NamedQuery(name = "Facturi.findByFacturaNumar", query = "SELECT f FROM Facturi f WHERE f.facturaNumar = :facturaNumar")})
public class Facturi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "facturaSerie")
    private String facturaSerie;
    @Column(name = "facturaNumar")
    private String facturaNumar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturiId")
    private Collection<Liniifacturi> liniifacturiCollection;

    public Facturi() {
    }

    public Facturi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacturaSerie() {
        return facturaSerie;
    }

    public void setFacturaSerie(String facturaSerie) {
        this.facturaSerie = facturaSerie;
    }

    public String getFacturaNumar() {
        return facturaNumar;
    }

    public void setFacturaNumar(String facturaNumar) {
        this.facturaNumar = facturaNumar;
    }

    @XmlTransient
    public Collection<Liniifacturi> getLiniifacturiCollection() {
        return liniifacturiCollection;
    }

    public void setLiniifacturiCollection(Collection<Liniifacturi> liniifacturiCollection) {
        this.liniifacturiCollection = liniifacturiCollection;
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
        if (!(object instanceof Facturi)) {
            return false;
        }
        Facturi other = (Facturi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Facturi[ id=" + id + " ]";
    }
    
}
