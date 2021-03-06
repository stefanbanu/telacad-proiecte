/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.telacad.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 *
 * @author student
 */
@Configuration
@ComponentScan(basePackages = {"ro.telacad.*"}, 
        excludeFilters = {
           @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class ProjectConfig {
    
}
