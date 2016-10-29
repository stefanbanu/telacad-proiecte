/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "urmariti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrmaritiDB.findAll", query = "SELECT u FROM UrmaritiDB u"),
    @NamedQuery(name = "UrmaritiDB.findById", query = "SELECT u FROM UrmaritiDB u WHERE u.id = :id"),
    @NamedQuery(name = "UrmaritiDB.findByIdP", query = "SELECT u FROM UrmaritiDB u WHERE u.idP = :idP"),
    @NamedQuery(name = "UrmaritiDB.findByDescriere", query = "SELECT u FROM UrmaritiDB u WHERE u.descriere = :descriere"),
    @NamedQuery(name = "UrmaritiDB.findByData", query = "SELECT u FROM UrmaritiDB u WHERE u.data = :data")})
public class UrmaritiDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_p")
    private int idP;
    @Basic(optional = false)
    @Column(name = "descriere")
    private String descriere;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public UrmaritiDB() {
    }

    public UrmaritiDB(Integer id) {
        this.id = id;
    }

    public UrmaritiDB(Integer id, int idP, String descriere, Date data) {
        this.id = id;
        this.idP = idP;
        this.descriere = descriere;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof UrmaritiDB)) {
            return false;
        }
        UrmaritiDB other = (UrmaritiDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UrmaritiDB[ id=" + id + " ]";
    }
    
}
