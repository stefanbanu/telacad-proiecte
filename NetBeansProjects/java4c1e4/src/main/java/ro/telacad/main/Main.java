/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import ro.telacad.beans.Ambalaj;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c1e4\\src\\main\\java\\ro\\telacad\\config\\appContext.xml");
        Ambalaj a = context.getBean(Ambalaj.class);
        System.out.println("CULOARE: "+a.getCuloare());
        System.out.println("NUME: "+a.getProdus().getNume());
    }
}
