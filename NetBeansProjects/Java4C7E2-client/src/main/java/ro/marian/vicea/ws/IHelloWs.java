package ro.marian.vicea.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://ws.vicea.marian.ro/")
public interface IHelloWs {
    
    @WebMethod
    public String sayHello(@WebParam(name = "name_to_say_hello") String name);
}
