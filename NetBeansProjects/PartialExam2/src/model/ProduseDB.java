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
@Table(name = "produse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduseDB.findAll", query = "SELECT p FROM ProduseDB p"),
    @NamedQuery(name = "ProduseDB.findByIdProduse", query = "SELECT p FROM ProduseDB p WHERE p.idProduse = :idProduse"),
    @NamedQuery(name = "ProduseDB.findByNumeProdus", query = "SELECT p FROM ProduseDB p WHERE p.numeProdus = :numeProdus"),
    @NamedQuery(name = "ProduseDB.findByPretProdus", query = "SELECT p FROM ProduseDB p WHERE p.pretProdus = :pretProdus")})
public class ProduseDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduse")
    private Integer idProduse;
    @Column(name = "numeProdus")
    private String numeProdus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pretProdus")
    private Double pretProdus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdus")
    private Collection<Detaliifacturi> detaliifacturiCollection;

    public ProduseDB() {
    }

    public ProduseDB(Integer idProduse) {
        this.idProduse = idProduse;
    }

    public Integer getIdProduse() {
        return idProduse;
    }

    public void setIdProduse(Integer idProduse) {
        this.idProduse = idProduse;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public Double getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(Double pretProdus) {
        this.pretProdus = pretProdus;
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
        hash += (idProduse != null ? idProduse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduseDB)) {
            return false;
        }
        ProduseDB other = (ProduseDB) object;
        if ((this.idProduse == null && other.idProduse != null) || (this.idProduse != null && !this.idProduse.equals(other.idProduse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProduseDB[ idProduse=" + idProduse + " ]";
    }
    
}
