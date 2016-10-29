/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.Punct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class<?> punctClass = Class.forName("beans.Punct");
            Constructor constrPunct = 
                    punctClass.getDeclaredConstructor();
            
            constrPunct.setAccessible(true);
            Punct punct = (Punct) constrPunct.newInstance();
            System.out.println(punct);
            
            Field[] f = punctClass.getDeclaredFields();
            for(Field x: f){
                x.setAccessible(true);
                if(x.isAnnotationPresent(Aleator.class)){
                    x.setInt(punct, new Random().nextInt());
                }
                
                if(x.isAnnotationPresent(Atribuie.class)){
                    Atribuie a = x.getDeclaredAnnotation(Atribuie.class);
                    x.setInt(punct, a.value());
                }
            }
            
            Method m = punctClass.getDeclaredMethod("afisareXY", null);
            m.setAccessible(true);
            m.invoke(punct, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
