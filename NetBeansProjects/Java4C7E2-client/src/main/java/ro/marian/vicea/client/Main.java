package ro.marian.vicea.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.marian.vicea.config.ClientProjectConfig;
import ro.marian.vicea.ws.IHelloWs;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientProjectConfig.class);
        
        IHelloWs helloWs = context.getBean(IHelloWs.class);
        System.out.println(helloWs.sayHello("Marian"));
    }
}
