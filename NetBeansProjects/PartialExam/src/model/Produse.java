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
    @NamedQuery(name = "Produse.findAll", query = "SELECT p FROM Produse p"),
    @NamedQuery(name = "Produse.findById", query = "SELECT p FROM Produse p WHERE p.id = :id"),
    @NamedQuery(name = "Produse.findByProdusNume", query = "SELECT p FROM Produse p WHERE p.produsNume = :produsNume"),
    @NamedQuery(name = "Produse.findByProdusPret", query = "SELECT p FROM Produse p WHERE p.produsPret = :produsPret")})
public class Produse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "produsNume")
    private String produsNume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produsPret")
    private Double produsPret;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produseId")
    private Collection<Liniifacturi> liniifacturiCollection;

    public Produse() {
    }

    public Produse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdusNume() {
        return produsNume;
    }

    public void setProdusNume(String produsNume) {
        this.produsNume = produsNume;
    }

    public Double getProdusPret() {
        return produsPret;
    }

    public void setProdusPret(Double produsPret) {
        this.produsPret = produsPret;
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
