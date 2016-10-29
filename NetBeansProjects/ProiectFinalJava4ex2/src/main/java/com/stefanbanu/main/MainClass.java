/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanbanu.main;

import com.stefanbanu.config.ProjectConfig;
import com.stefanbanu.view.LoginFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Stefan
 */
public class MainClass {
 
    public static void main(String[] args) {
              AnnotationConfigApplicationContext context = 
                      new AnnotationConfigApplicationContext(ProjectConfig.class);
              
              new LoginFrame();
    }
}
