/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import ro.telacad.service.ProductService;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        FileSystemXmlApplicationContext context;
        context = new FileSystemXmlApplicationContext("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c2e7\\src\\main\\java\\ro\\telacad\\config\\appContext.xml");
        ProductService service = context.getBean(ProductService.class);
        service.adaugaProdus("ciocolata", 10);
    }
}
