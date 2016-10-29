/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Laur
 */
public class Admin implements java.io.Serializable{
    private int id;
    private String user,parola;

    public Admin() {
    }

    public Admin(String user, String parola) {
        this.user = user;
        this.parola = parola;
    }

    public Admin(int id, String user, String parola) {
        this.id = id;
        this.user = user;
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
