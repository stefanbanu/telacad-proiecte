package ro.marian.vicea.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.marian.vicea.services.LoginService;

@ManagedBean // Pt JSF
@Component // Pt Spring
@RequestScoped // E scopul default, dar e bine sa il trecem
public class User implements Serializable {
    private String username;
    private String password;
    private String message;
    
    @Autowired
    private LoginService service;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void afisareNumeSiParola() {
        service.adaugaUser(username, password);
    }
    
    public void login() {
        boolean login = service.login(username, password);
        if (login) {
            this.message = "Login reusit!";
        } else {
            this.message = "Login esuat!";
        }
    }
}
