/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.util;

/**
 *
 * @author cascau
 */
public enum InstrumentType {
    
    DEFAULT(0L, "default"),
    GUITAR(1L, "guitar"),
    BASS(2L, "bass guitar"),
    DRUMS(3L, "drums"), 
    VOCALS(4L, "vocals"),
    KEYBOARD(5L, "keyboard");
    
    private final Long id;
    private final String name;


    private InstrumentType(Long id, String name) {
        this.id = id;
        this.name = name;    
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
