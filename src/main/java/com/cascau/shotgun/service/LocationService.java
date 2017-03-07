/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.dto.LocationRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.performer.Performer;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class LocationService extends BaseService {
    
    public List<Location> getLocations(LocationRequestDto request) {
        
        return null;
    }
    
    public List<Event> getEventsByLocation(LocationRequestDto request) {
        
        return null;
    }
        
    public List<Performer> getPerformersByLocation(LocationRequestDto request) {
        
        return null;
    }
            
    public List<Actor> getActorsByLocation(LocationRequestDto request) {
        
        return null;
    }
}
