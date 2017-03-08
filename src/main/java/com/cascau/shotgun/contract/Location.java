/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.contract;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cascau
 */
public class Location {
    
    private Long id;
    private String name;
    private String address;
    private String country;
    private List<Long> gpsCoords = new ArrayList<>(2);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Long> getGpsCoords() {
        return gpsCoords;
    }

    public void setGpsCoords(List<Long> gpsCoords) {
        this.gpsCoords = gpsCoords;
    }    

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
