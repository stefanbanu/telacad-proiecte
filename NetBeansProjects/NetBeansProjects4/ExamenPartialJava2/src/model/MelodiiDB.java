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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "melodii")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MelodiiDB.findAll", query = "SELECT m FROM MelodiiDB m"),
    @NamedQuery(name = "MelodiiDB.findById", query = "SELECT m FROM MelodiiDB m WHERE m.id = :id"),
    @NamedQuery(name = "MelodiiDB.findByNume", query = "SELECT m FROM MelodiiDB m WHERE m.nume = :nume"),
    @NamedQuery(name = "MelodiiDB.findByGen", query = "SELECT m FROM MelodiiDB m WHERE m.gen = :gen")})
public class MelodiiDB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nume")
    private String nume;
    @Column(name = "gen")
    private String gen;
    @JoinTable(name = "melodii_has_artisti", joinColumns = {
        @JoinColumn(name = "melodii_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "artisti_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ArtistiDB> artistiDBCollection;

    public MelodiiDB() {
    }

    public MelodiiDB(Integer id) {
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @XmlTransient
    public Collection<ArtistiDB> getArtistiDBCollection() {
        return artistiDBCollection;
    }

    public void setArtistiDBCollection(Collection<ArtistiDB> artistiDBCollection) {
        this.artistiDBCollection = artistiDBCollection;
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
        if (!(object instanceof MelodiiDB)) {
            return false;
        }
        MelodiiDB other = (MelodiiDB) object;
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
