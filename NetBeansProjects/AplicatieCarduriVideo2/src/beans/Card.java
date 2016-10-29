
package beans;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Card implements Serializable{
    
    private int id;
    private String iban;
    private double amount;
    private int client;

    public Card() {
    }

    public Card(int id, String iban, double amount, int client) {
        this.id = id;
        this.iban = iban;
        this.amount = amount;
        this.client = client;
    }

    public Card(String iban, double amount, int client) {
        this.iban = iban;
        this.amount = amount;
        this.client = client;
    }

    public Card(String iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public String toString() {
        return "Card{" + "iban=" + iban + '}';
    }        
    
}
