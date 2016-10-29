package ro.marian.vicea.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloservice")
public class HelloService {
    
    @GET
    @Produces("text/html")
    @Path("/sayhello")
    public String sayHello() {
        return "Hello World!";
    }
    
    @GET
    @Produces("application/xml")
    //@Produces("application/json")
    @Path("/cat")
    public Pisica getPisica() {
        Pisica p = new Pisica();
        p.setNume("Tom");
        p.setCuloare("alb");
        
        return p;
    }
}
