package ro.marian.vicea.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.marian.vicea.config.ClientProjectConfig;
import ro.marian.vicea.rmi.IHelloService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ClientProjectConfig.class);
        
        IHelloService service = context.getBean(IHelloService.class);
        System.out.println(service.sayHello("Marian"));
    }
}
