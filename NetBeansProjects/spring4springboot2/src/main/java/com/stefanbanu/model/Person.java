/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stefanbanu.model;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stefan
 */
@XmlRootElement
public class Person {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
