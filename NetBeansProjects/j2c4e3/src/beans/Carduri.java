/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laur
 */
@Entity
@Table(name = "carduri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carduri.findAll", query = "SELECT c FROM Carduri c"),
    @NamedQuery(name = "Carduri.findById", query = "SELECT c FROM Carduri c WHERE c.id = :id"),
    @NamedQuery(name = "Carduri.findByAmount", query = "SELECT c FROM Carduri c WHERE c.amount = :amount"),
    @NamedQuery(name = "Carduri.findByClient", query = "SELECT c FROM Carduri c WHERE c.client = :client")})
public class Carduri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "iban")
    private String iban;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @Column(name = "client")
    private int client;

    public Carduri() {
    }

    public Carduri(Integer id) {
        this.id = id;
    }

    public Carduri(Integer id, String iban, double amount, int client) {
        this.id = id;
        this.iban = iban;
        this.amount = amount;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
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
        if (!(object instanceof Carduri)) {
            return false;
        }
        Carduri other = (Carduri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return iban+" "+amount;
    }
    
}
