/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.contract.performer;

import com.cascau.shotgun.contract.Actor;
import java.util.List;

/**
 *
 * @author cascau
 */
public class Performer {

    private Long id;
    private String name;
    private List<Actor> members;

    private Performer() {
        
    }
    
    public Performer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
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

    public List<Actor> getMembers() {
        return members;
    }

    public void setMembers(List<Actor> members) {
        this.members = members;
    }
}
