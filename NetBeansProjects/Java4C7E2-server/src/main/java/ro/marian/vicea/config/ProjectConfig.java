package ro.marian.vicea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
@ComponentScan("ro.marian.vicea.*")
public class ProjectConfig {
    
    @Bean
    public SimpleJaxWsServiceExporter helloServiceExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        
        exporter.setBaseAddress("http://localhost:8888/services/");
        
        return exporter;
    }
}
