/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author student
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD})
public @interface MyAnnotation {
    public String value();
    public String ceva();
}
