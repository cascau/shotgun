/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.contract.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author cascau
 */
public class BaseRequestDto implements Serializable {
    
    private Long id;
    private String name;
    private Date startdt;
    private Date enddt;

    /**
     *
     */
    protected BaseRequestDto() {
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }
    
}
