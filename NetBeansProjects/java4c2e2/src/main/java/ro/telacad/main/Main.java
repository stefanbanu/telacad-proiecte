/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import ro.telacad.beans.Punct;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        FileSystemXmlApplicationContext context;
        context = new FileSystemXmlApplicationContext("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c2e2\\src\\main\\java\\ro\\telacad\\config\\appContext.xml");
        
        Punct p1 = context.getBean("punct1", Punct.class);
        System.out.println("x: "+p1.getX()+" "+"y: "+p1.getY());
        p1.setX(50); p1.setY(60);
        
        Punct p2 = context.getBean("punct1", Punct.class);
        System.out.println("x: "+p2.getX()+" "+"y: "+p2.getY());

        Punct p3 = context.getBean("punct2", Punct.class);
        System.out.println("x: "+p3.getX()+" "+"y: "+p3.getY());
        p3.setX(50); p3.setY(60);
        
        Punct p4 = context.getBean("punct2", Punct.class);
        System.out.println("x: "+p4.getX()+" "+"y: "+p4.getY());
    }
}
