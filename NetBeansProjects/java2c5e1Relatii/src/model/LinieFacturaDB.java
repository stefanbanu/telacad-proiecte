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
 * @author student
 */
@Entity
@Table(name = "liniifacturi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinieFacturaDB.findAll", query = "SELECT l FROM LinieFacturaDB l"),
    @NamedQuery(name = "LinieFacturaDB.findById", query = "SELECT l FROM LinieFacturaDB l WHERE l.id = :id"),
    @NamedQuery(name = "LinieFacturaDB.findByQty", query = "SELECT l FROM LinieFacturaDB l WHERE l.qty = :qty")})
public class LinieFacturaDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @JoinColumn(name = "produs", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdusDB produs;
    @JoinColumn(name = "factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FacturaDB factura;

    public LinieFacturaDB() {
    }

    public LinieFacturaDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public ProdusDB getProdus() {
        return produs;
    }

    public void setProdus(ProdusDB produs) {
        this.produs = produs;
    }

    public FacturaDB getFactura() {
        return factura;
    }

    public void setFactura(FacturaDB factura) {
        this.factura = factura;
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
        if (!(object instanceof LinieFacturaDB)) {
            return false;
        }
        LinieFacturaDB other = (LinieFacturaDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produs.getNume()+" "+produs.getPret()+" "+qty;
    }
    
}
