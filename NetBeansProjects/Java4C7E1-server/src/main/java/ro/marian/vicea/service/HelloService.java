package ro.marian.vicea.service;

import org.springframework.stereotype.Service;
import ro.marian.vicea.rmi.IHelloService;

@Service
public class HelloService implements IHelloService {
    
    @Override
    public String sayHello(String nume) {
        return "Salut, " + nume + "!";
    }
    
}
