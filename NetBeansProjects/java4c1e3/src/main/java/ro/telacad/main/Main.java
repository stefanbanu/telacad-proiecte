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
        FileSystemXmlApplicationContext context = 
                new FileSystemXmlApplicationContext("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c1e3\\src\\main\\java\\ro\\telacad\\config\\appContext.xml");
        Punct p1 = context.getBean("punct1",Punct.class);
        System.out.println(p1.getX()+" "+p1.getY()); 
        
        context.close();
    }
}
