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
 * @author student
 */
@Entity
@Table(name = "utilizatori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtilizatoriDB.findAll", query = "SELECT u FROM UtilizatoriDB u"),
    @NamedQuery(name = "UtilizatoriDB.findById", query = "SELECT u FROM UtilizatoriDB u WHERE u.id = :id"),
    @NamedQuery(name = "UtilizatoriDB.findByUser", query = "SELECT u FROM UtilizatoriDB u WHERE u.user = :user"),
    @NamedQuery(name = "UtilizatoriDB.findByParola", query = "SELECT u FROM UtilizatoriDB u WHERE u.parola = :parola"),
    @NamedQuery(name = "UtilizatoriDB.findByAdmin", query = "SELECT u FROM UtilizatoriDB u WHERE u.admin = :admin")})
public class UtilizatoriDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "parola")
    private String parola;
    @Basic(optional = false)
    @Column(name = "admin")
    private String admin;

    public UtilizatoriDB() {
    }

    public UtilizatoriDB(Integer id) {
        this.id = id;
    }

    public UtilizatoriDB(Integer id, String user, String parola, String admin) {
        this.id = id;
        this.user = user;
        this.parola = parola;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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
        if (!(object instanceof UtilizatoriDB)) {
            return false;
        }
        UtilizatoriDB other = (UtilizatoriDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UtilizatoriDB[ id=" + id + " ]";
    }
    
}
