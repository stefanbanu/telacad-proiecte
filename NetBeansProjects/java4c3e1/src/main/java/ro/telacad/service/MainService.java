/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author student
 */
@Service
public class MainService {
    
    @Autowired
    @QualifierServiceB
    private IMyService service;
    
    public void exemplu(){
        service.m1();
    }
}
