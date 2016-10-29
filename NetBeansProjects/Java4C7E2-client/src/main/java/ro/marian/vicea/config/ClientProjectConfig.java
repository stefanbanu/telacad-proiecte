package ro.marian.vicea.config;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import ro.marian.vicea.ws.IHelloWs;

@Configuration
@ComponentScan("ro.marian.vicea.*")
public class ClientProjectConfig {
    
    @Bean
    public JaxWsPortProxyFactoryBean helloService() {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        
        try {
            proxy.setWsdlDocumentUrl(new URL("http://localhost:8888/services/?wsdl"));
            proxy.setServiceName("HelloWsService");
            proxy.setPortName("HelloWsPort");
            proxy.setServiceInterface(IHelloWs.class);
            proxy.setNamespaceUri("http://ws.vicea.marian.ro/");
            
        } catch(MalformedURLException e) {
            
        }
        return proxy;
    }
}
