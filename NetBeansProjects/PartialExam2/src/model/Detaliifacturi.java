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
@Table(name = "detaliifacturi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detaliifacturi.findAll", query = "SELECT d FROM Detaliifacturi d"),
    @NamedQuery(name = "Detaliifacturi.findByIdDetaliiFacturi", query = "SELECT d FROM Detaliifacturi d WHERE d.idDetaliiFacturi = :idDetaliiFacturi"),
    @NamedQuery(name = "Detaliifacturi.findByCantitateProdus", query = "SELECT d FROM Detaliifacturi d WHERE d.cantitateProdus = :cantitateProdus")})
public class Detaliifacturi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetaliiFacturi")
    private Integer idDetaliiFacturi;
    @Column(name = "cantitateProdus")
    private Integer cantitateProdus;
    @JoinColumn(name = "id_factura", referencedColumnName = "idFacturi")
    @ManyToOne(optional = false)
    private FacturiDB idFactura;
    @JoinColumn(name = "id_produs", referencedColumnName = "idProduse")
    @ManyToOne(optional = false)
    private ProduseDB idProdus;

    public Detaliifacturi() {
    }

    public Detaliifacturi(Integer idDetaliiFacturi) {
        this.idDetaliiFacturi = idDetaliiFacturi;
    }

    public Integer getIdDetaliiFacturi() {
        return idDetaliiFacturi;
    }

    public void setIdDetaliiFacturi(Integer idDetaliiFacturi) {
        this.idDetaliiFacturi = idDetaliiFacturi;
    }

    public Integer getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(Integer cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    public FacturiDB getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(FacturiDB idFactura) {
        this.idFactura = idFactura;
    }

    public ProduseDB getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(ProduseDB idProdus) {
        this.idProdus = idProdus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetaliiFacturi != null ? idDetaliiFacturi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detaliifacturi)) {
            return false;
        }
        Detaliifacturi other = (Detaliifacturi) object;
        if ((this.idDetaliiFacturi == null && other.idDetaliiFacturi != null) || (this.idDetaliiFacturi != null && !this.idDetaliiFacturi.equals(other.idDetaliiFacturi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Detaliifacturi[ idDetaliiFacturi=" + idDetaliiFacturi + " ]";
    }
    
}
