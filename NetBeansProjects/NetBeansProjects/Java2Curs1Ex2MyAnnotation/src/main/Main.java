/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import annotations.Aleator;
import beans.Punct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

/**
 *
 * @author student
 */
public class Main {
    private static Random r = new Random();
    public static void main(String [] args){
        try{
            Constructor<Punct> c = 
                    Punct.class.getDeclaredConstructor(String.class);
            
            c.setAccessible(true);
            Punct p1 = c.newInstance("A FOST CREAT UN PUNCT");
            
            Field [] fields = Punct.class.getDeclaredFields();
            for(Field f: fields){
                if(f.isAnnotationPresent(Aleator.class)){
                    f.setAccessible(true);
                    f.setInt(p1, r.nextInt(1000));
                }
            }
            
            p1.afisareXYZ();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
