/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.controllermb;

import com.stefanbanu.config.ProjectConfig;
import com.stefanbanu.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Stefan
 */
public class UtilClass {

   // private static AnnotationConfigApplicationContext context;

    public static AnnotationConfigApplicationContext getContext() {
    
        /*try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
        //   ProductService service = context.getBean(ProductService.class);
        //    service.adaugaZeceProduse();
        }*/

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        return context;
    }

}
