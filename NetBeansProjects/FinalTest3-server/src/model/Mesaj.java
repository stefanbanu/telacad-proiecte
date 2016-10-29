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
@Table(name = "mesaj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesaj.findAll", query = "SELECT m FROM Mesaj m"),
    @NamedQuery(name = "Mesaj.findById", query = "SELECT m FROM Mesaj m WHERE m.id = :id"),
    @NamedQuery(name = "Mesaj.findByMesaj", query = "SELECT m FROM Mesaj m WHERE m.mesaj = :mesaj"),
    @NamedQuery(name = "Mesaj.findByUsersId", query = "SELECT m FROM Mesaj m WHERE m.usersId = :usersId")})
public class Mesaj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mesaj")
    private String mesaj;
    @Basic(optional = false)
    @Column(name = "users_id")
    private int usersId;

    public Mesaj() {
    }

    public Mesaj(Integer id) {
        this.id = id;
    }

    public Mesaj(Integer id, String mesaj, int usersId) {
        this.id = id;
        this.mesaj = mesaj;
        this.usersId = usersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
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
        if (!(object instanceof Mesaj)) {
            return false;
        }
        Mesaj other = (Mesaj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mesaj[ id=" + id + " ]";
    }
    
}
