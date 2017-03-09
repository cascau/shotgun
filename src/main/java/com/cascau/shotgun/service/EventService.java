/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.Sponsor;
import com.cascau.shotgun.contract.Ticket;
import com.cascau.shotgun.contract.dto.BaseRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.dto.EventRequestDto;
import com.cascau.shotgun.contract.performer.Performer;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class EventService extends BaseService {
    
    
    public List<Event> getEvents(final EventRequestDto request) throws SQLException {
        
        List<Event> events = this.eventDao.getEvents(request);
        return events;
    }
    
    public List<Performer> getPerformersByEvent(final EventRequestDto request) throws SQLException {
        
        List<Performer> performers = this.performerDao.getPerformersByEvent(request);
        return performers;
    }
    
    public List<Actor> getActorsByEvent(final EventRequestDto request) {
        
        List<Actor> actors = this.actorDao.getActors(request);
        return actors;
    }
    
    public List<Ticket> getTicketsByEvent(final EventRequestDto request) {
        
        return null;
    }
    
    public List<Sponsor> getSponsorsByEvent(final EventRequestDto request) {
        
        return null;
    }
    
    public List<Location> getLocationsByEvent(final BaseRequestDto request) throws SQLException {
        
        List<Location> locations = this.locationDao.getLocationsByEventId(request);
        return locations;
    }
}
