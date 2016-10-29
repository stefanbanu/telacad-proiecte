/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "artisti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtistiDB.findAll", query = "SELECT a FROM ArtistiDB a"),
    @NamedQuery(name = "ArtistiDB.findById", query = "SELECT a FROM ArtistiDB a WHERE a.id = :id"),
    @NamedQuery(name = "ArtistiDB.findByNume", query = "SELECT a FROM ArtistiDB a WHERE a.nume = :nume")})
public class ArtistiDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nume")
    private String nume;
    @ManyToMany(mappedBy = "artistiDBCollection")
    private Collection<MelodiiDB> melodiiDBCollection;

    public ArtistiDB() {
    }

    public ArtistiDB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @XmlTransient
    public Collection<MelodiiDB> getMelodiiDBCollection() {
        return melodiiDBCollection;
    }

    public void setMelodiiDBCollection(Collection<MelodiiDB> melodiiDBCollection) {
        this.melodiiDBCollection = melodiiDBCollection;
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
        if (!(object instanceof ArtistiDB)) {
            return false;
        }
        ArtistiDB other = (ArtistiDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nume;
    }
    
}
