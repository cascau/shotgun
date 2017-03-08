/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.Instrument;
import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.Release;
import com.cascau.shotgun.contract.dto.ActorRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.performer.Performer;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class ActorService extends BaseService {
    
    public List<Actor> getActors(final ActorRequestDto request) {
        
        List<Actor> actors = this.actorDao.getActors(request);
        return actors;
    }
    
    public List<Performer> getPerformersByActor(final ActorRequestDto request) {
        
        List<Performer> performers = this.performerDao.getPerformersByActor(request);
        return performers;
    }
    
    public List<Event> getEventsByActor(final ActorRequestDto request) throws SQLException {
        
        List<Event> events = this.eventDao.getEvents(request);
        return events;
    }
    
    public List<Instrument> getInstrumentsByActor(final ActorRequestDto request) {
        
        List<Instrument> instruments = this.instrumentDao.getInstrumentsByActor(request);
        return instruments;
    }
    
    public List<Release> getReleasesByActor(final ActorRequestDto request) {
        
        List<Release> releases = this.releaseDao.getReleasesByActor(request);
        return releases;
    }
    
    public List<Location> getLocationsByActor(final ActorRequestDto request) throws SQLException {
        
        List<Location> locations = this.locationDao.getLocations(request);
        return locations;
    }
}

