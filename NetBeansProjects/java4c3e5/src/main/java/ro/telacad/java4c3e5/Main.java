/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.java4c3e5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.config.ProjectConfig;
import ro.telacad.service.ProductService;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        try(AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(ProjectConfig.class)){
            ProductService service = context.getBean(ProductService.class);
            service.adaugaProdus("bere");
            service.adaugaProdus("bere");
            service.stergeProdus("bere");
        }
    }
}
