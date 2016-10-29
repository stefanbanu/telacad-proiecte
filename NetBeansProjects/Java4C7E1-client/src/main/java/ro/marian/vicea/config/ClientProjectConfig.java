package ro.marian.vicea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.marian.vicea.rmi.IHelloService;

@Configuration
@ComponentScan("ro.marian.vicea.*")
public class ClientProjectConfig {
    
    @Bean
    public RmiProxyFactoryBean helloService() {
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        
        proxy.setServiceUrl("rmi://localhost:4321/HelloService");
        proxy.setServiceInterface(IHelloService.class);
        
        return proxy;
    }
}
