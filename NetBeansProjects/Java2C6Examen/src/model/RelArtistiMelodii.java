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
@Table(name = "rel_artisti_melodii")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelArtistiMelodii.findAll", query = "SELECT r FROM RelArtistiMelodii r"),
    @NamedQuery(name = "RelArtistiMelodii.findById", query = "SELECT r FROM RelArtistiMelodii r WHERE r.id = :id"),
    @NamedQuery(name = "RelArtistiMelodii.findMelodiiByArtist", query = "SELECT r.fkMelodii FROM RelArtistiMelodii r WHERE r.fkArtisti = :fkArtisti")})
public class RelArtistiMelodii implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "fk_artisti", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artisti fkArtisti;
    @JoinColumn(name = "fk_melodii", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Melodii fkMelodii;

    public RelArtistiMelodii() {
    }

    public RelArtistiMelodii(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artisti getFkArtisti() {
        return fkArtisti;
    }

    public void setFkArtisti(Artisti fkArtisti) {
        this.fkArtisti = fkArtisti;
    }

    public Melodii getFkMelodii() {
        return fkMelodii;
    }

    public void setFkMelodii(Melodii fkMelodii) {
        this.fkMelodii = fkMelodii;
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
        if (!(object instanceof RelArtistiMelodii)) {
            return false;
        }
        RelArtistiMelodii other = (RelArtistiMelodii) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RelArtistiMelodii[ id=" + id + " ]";
    }
    
}
