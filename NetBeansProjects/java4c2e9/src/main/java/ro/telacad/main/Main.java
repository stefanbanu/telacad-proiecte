/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.beans.Casa;
import ro.telacad.config.ProjectConfig;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        AnnotationConfigApplicationContext context;
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    
        Casa casa = context.getBean(Casa.class);
        System.out.println(casa.getPisica().getCuloare());
    }
}
