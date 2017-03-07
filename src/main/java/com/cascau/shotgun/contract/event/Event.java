/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.contract.event;

import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.Sponsor;
import com.cascau.shotgun.contract.Ticket;
import com.cascau.shotgun.contract.performer.Performer;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author cascau
 */
public abstract class Event {
    
    private Long id;
    private String name;
    private Date startdt;
    private Date enddt;
    
    private List<Performer> performers;
    private List<Ticket> tickets;
    private List<Location> locations;
    private List<Sponsor> sponsors;
    
    private Event() {
        
    }
    
    public Event(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Event(Long id, String name, Date startdt, Date enddt) {
        this(id, name);
        this.startdt = startdt;
        this.enddt = enddt;
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

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    
}
