/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Stefan
 */
@Path("/helloservice")
public class HelloService {
    
    @GET
    @Produces("text/html")
    @Path("/sayHello")
    public String sayHello(){
        return "Hello World!";
    }
    
    @GET
    @Produces("application/xml")
    @Path("/user")
    public User getUser(){
        User u = new User();
        u.setNume("Stefan");
        u.setParola("1234");
        return u;
    }
}
