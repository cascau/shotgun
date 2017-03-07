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
import com.cascau.shotgun.contract.dto.PerformerRequestDto;
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
public class PerformerService extends BaseService {

    public List<Performer> getPerformerById(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Performer> getPerformersByEvent(PerformerRequestDto request) throws SQLException {
        
        List<Performer> performers = this.performerDao.getPerformersByEvent(request);
        return performers;
    }
    
    public List<Actor> getActorsByPerformer(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Event> getEventsByPerformer(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Instrument> getInstrumentsByPerformer(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Release> getEReleasesByPerformer(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Location> getLocationsByPerformer(PerformerRequestDto request) {
        
        return null;
    }
    
    public List<Performer> getPerformersByEventId(Long eventId) {
        
        return null;
    }
}
