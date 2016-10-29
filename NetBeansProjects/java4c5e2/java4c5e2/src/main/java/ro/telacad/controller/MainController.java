/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author student
 */
@Controller
public class MainController {
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeAction(Model model){
        model.addAttribute("nume", "John");
        return "home";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String homeActionPost(String nume, Model model){
        model.addAttribute("nume", nume);
        return "home";
    }
}
