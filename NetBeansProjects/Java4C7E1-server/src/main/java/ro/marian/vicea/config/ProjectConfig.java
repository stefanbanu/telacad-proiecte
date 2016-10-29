package ro.marian.vicea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.marian.vicea.rmi.IHelloService;
import ro.marian.vicea.service.HelloService;

@Configuration
@ComponentScan("ro.marian.vicea.*")
public class ProjectConfig {
    
    @Bean
    @Autowired
    public RmiServiceExporter rmiExporter(HelloService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        
        exporter.setServiceName("HelloService");
        exporter.setService(service);
        exporter.setServiceInterface(IHelloService.class);
        //exporter.setRegistryHost("localhost");
        exporter.setRegistryPort(4321);
        
        return exporter;
    }
}
