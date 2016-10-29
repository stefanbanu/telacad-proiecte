/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.java4c3e4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.config.ProjectConfig;
import ro.telacad.service.MyService;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        try(AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(ProjectConfig.class)){
            MyService service = context.getBean(MyService.class);
            service.myUseCase();
        }
    }
}
