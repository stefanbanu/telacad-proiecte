/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.config.ProjectConfig;
import com.mycompany.controller.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Marian
 */
public class Main {
    public static void main(String[] args) {
        
        // Try / catch cu resursa. Resursa trebuie sa fie auto-closable (adica sa aiba metoda close())
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductService service = context.getBean(ProductService.class);
            
            service.adaugaProdus("Vin");
        }
    }
}
