/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author student
 */
@Service
@QualifierServiceA
public class MyServiceA implements IMyService{

    @Override
    public void m1() {
        System.out.println("MyServiceA");
    }
    
}
