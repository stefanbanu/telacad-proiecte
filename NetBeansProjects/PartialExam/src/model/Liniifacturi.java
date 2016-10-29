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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "liniifacturi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liniifacturi.findAll", query = "SELECT l FROM Liniifacturi l"),
    @NamedQuery(name = "Liniifacturi.findById", query = "SELECT l FROM Liniifacturi l WHERE l.id = :id"),
    @NamedQuery(name = "Liniifacturi.findByCantitate", query = "SELECT l FROM Liniifacturi l WHERE l.cantitate = :cantitate")})
public class Liniifacturi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantitate")
    private Integer cantitate;
    @JoinColumn(name = "facturi_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Facturi facturiId;
    @JoinColumn(name = "produse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produse produseId;

    public Liniifacturi() {
    }

    public Liniifacturi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantitate() {
        return cantitate;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    public Facturi getFacturiId() {
        return facturiId;
    }

    public void setFacturiId(Facturi facturiId) {
        this.facturiId = facturiId;
    }

    public Produse getProduseId() {
        return produseId;
    }

    public void setProduseId(Produse produseId) {
        this.produseId = produseId;
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
        if (!(object instanceof Liniifacturi)) {
            return false;
        }
        Liniifacturi other = (Liniifacturi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Liniifacturi[ id=" + id + " ]";
    }
    
}
