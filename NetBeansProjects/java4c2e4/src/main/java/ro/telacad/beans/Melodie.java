/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author student
 */
public class Melodie {
    
    @Autowired
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    
    
}
