/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.beans.Punct;
import ro.telacad.config.ProjectConfig;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        try(AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(
                        ProjectConfig.class)){
            Punct p1 = context.getBean(Punct.class);
            System.out.println(p1.getX()+" "+p1.getY());
            p1.setX(90); p1.setY(100);
            
            Punct p2 = context.getBean(Punct.class);
            System.out.println(p2.getX()+" "+p2.getY());
        }
    }
}
