/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.config.ProjectConfig;
import ro.telacad.service.ProductService;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        AnnotationConfigApplicationContext context; 
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        ProductService service = context.getBean(ProductService.class);
        long t1 = System.currentTimeMillis();
        service.getProductThreeTimes();
        long t2 = System.currentTimeMillis();
        System.out.println("DURATA: "+(t2-t1));
        
        context.close();
    }
}
