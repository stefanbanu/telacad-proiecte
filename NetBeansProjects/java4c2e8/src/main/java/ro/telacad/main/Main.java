/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.telacad.beans.Cerc;
import ro.telacad.config.ProjectConfig;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        AnnotationConfigApplicationContext context;
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        Cerc cerc = context.getBean(Cerc.class);
        System.out.println(cerc.getRaza());
        System.out.println(cerc.getCentru().getX());
        System.out.println(cerc.getCentru().getY());
    }
}
