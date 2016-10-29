/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.controllermb;

import com.stefanbanu.config.ProjectConfig;
import com.stefanbanu.model.UserDB;
import com.stefanbanu.service.UserService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Stefan
 */
@ManagedBean
@RequestScoped
public class UserMB implements Serializable {

    private int id;
    private String nume;
    private String parola;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Autowired
    UserService service;

    public UserService getService() {
       UserService service1 = UtilClass.getContext().getBean(UserService.class);
        return service1;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public void registerUser() {
        System.out.println("register user ===============================");
        System.out.println(getNume());
        System.out.println(getParola());
        try {
            UserDB u = new UserDB();
            u.setNume(getNume());

            u.setParola(getParola());
            System.out.println("inainte de getSErvice");
            //getService().registerUser(u);
          //  service = UtilClass.getContext().getBean(UserService.class);
          AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
          service = context.getBean(UserService.class);
          service.registerUser(u);
          context.close();
          System.out.println("dupa getSErvice");
        } catch (Exception e) {
            e.getMessage();
        }
    }
        public void login() {

            UserDB u = new UserDB();
            u.setNume(getNume());

            u.setParola(getParola());
            getService().loginUser(u);
            System.out.println("======================"+u.getId());
            System.out.println("==============="+u.getNume());
            System.out.println("========================="+u.getParola());

    }

}
