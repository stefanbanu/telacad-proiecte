/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import ro.telacad.beans.Cerc;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String [] args){
        FileSystemXmlApplicationContext context = null;
        try{
            context = new FileSystemXmlApplicationContext("C:\\Users\\student\\Documents\\NetBeansProjects\\java4c2e1\\src\\main\\java\\ro\\telacad\\config\\appContext.xml");
            Cerc cerc1 = context.getBean(Cerc.class);
            System.out.println(cerc1.getRaza());
            System.out.println(cerc1.getCentru().getX());
            System.out.println(cerc1.getCentru().getY());
        }finally{
           if(context != null) context.close();
        }
    }
}
