package ro.marian.vicea.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.marian.vicea.service.HelloService;

@WebService
@Component
public class HelloWs {
    
    @Autowired
    private HelloService service;
    
    @WebMethod
    public String sayHello(@WebParam(name = "name_to_say_hello") String name) {
        return service.sayHello(name);
    }
}
