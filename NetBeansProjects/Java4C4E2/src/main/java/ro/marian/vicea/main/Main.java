package ro.marian.vicea.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.marian.vicea.config.ProjectConfig;
import ro.marian.vicea.service.ProductService;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductService service = context.getBean(ProductService.class);
            service.adaugaZeceProduse();
        }
    }
}
