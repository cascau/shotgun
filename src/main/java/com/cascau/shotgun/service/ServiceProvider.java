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
import com.cascau.shotgun.contract.Sponsor;
import com.cascau.shotgun.contract.Ticket;
import com.cascau.shotgun.contract.dto.ActorRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.dto.EventRequestDto;
import com.cascau.shotgun.contract.dto.InstrumentRequestDto;
import com.cascau.shotgun.contract.dto.LocationRequestDto;
import com.cascau.shotgun.contract.dto.PerformerRequestDto;
import com.cascau.shotgun.contract.dto.ReleaseRequestDto;
import com.cascau.shotgun.contract.dto.SponsorRequestDto;
import com.cascau.shotgun.contract.dto.TicketRequestDto;
import com.cascau.shotgun.contract.performer.Performer;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class ServiceProvider extends BaseServiceProvider {

    /* 
    * Start ACTOR service
    */
    public List<Actor> getActors(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        } 
        
        final List<Actor> actors = this.actorService.getActors(request);
        return actors;
    }
    
    public List<Performer> getPerformersByActor(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Performer> performers = this.actorService.getPerformersByActor(request);
        return performers;
    }
    
    public List<Instrument> getInstrumentsByActor(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Instrument> instruments = this.actorService.getInstrumentsByActor(request);
        return instruments;
    }
    
    public List<Event> getEventsByActor(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Event> events = null;
        try {
            events = this.actorService.getEventsByActor(request);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
    
    public List<Release> getReleasesByActor(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Release> releases = this.actorService.getReleasesByActor(request);
        return releases;
    }
    
    public List<Location> getLocationsByActor(final ActorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Location> locations = this.actorService.getLocationsByActor(request);
        return locations;
    }
    /* 
    * End ACTOR service
    */
    
    /* 
    * Start EVENT service
    */
    public List<Event> getEvents(final EventRequestDto eventRequest) {
        
        if (eventRequest == null) {
            return null;
        }
        
        List<Event> events = null;
        try {
            // get events
            events = this.eventService.getEvents(eventRequest);
            
            if (events != null) {
                for (Event event : events) {
                    // get performers
                    PerformerRequestDto performerRequest = new PerformerRequestDto();
                    performerRequest.setId(event.getId());
                    performerRequest.setStartdt(eventRequest.getStartdt());
                    performerRequest.setEnddt(eventRequest.getEnddt());
                    
                    List<Performer> performers = this.getPerformers(performerRequest);
                    event.setPerformers(performers);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
    
    public List<Actor> getActorsByEvent(final EventRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Actor> actors = this.eventService.getActorsByEvent(request);
        return actors;
    }
    
    public List<Performer> getPerformersByEvent(final EventRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Performer> performers = null;
        try {

            performers = this.eventService.getPerformersByEvent(request);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return performers;
    }
    
    public List<Ticket> getTicketsByEvent(final EventRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Ticket> tickets = this.eventService.getTicketsByEvent(request);
        return tickets;
    } 
    
    public List<Sponsor> getSponsorsByEvent(final EventRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Sponsor> sponsors = this.eventService.getSponsorsByEvent(request);
        return sponsors;
    }
    
    public List<Location> getLocationsByEvent(final EventRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Location> locations = this.eventService.getLocationsByEvent(request);
        return locations;
    }
    /* 
    * End EVENT service
    */
    
    /* 
    * Start INSTRUMENT service
    */
    public List<Actor> getActorsByInstrument(final InstrumentRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Actor> actors = this.instrumentService.getActorsByInstrument(request);
        return actors;
    }
    /* 
    * End PERFORMER service
    */
    /* 
    * Start PERFORMER service
    */
    public List<Performer> getPerformers(final PerformerRequestDto request) throws SQLException {
                
        if (request == null) {
            return null;
        }
        
        List<Performer> performers = this.performerService.getPerformersByEvent(request);
        return performers;
    }
    
    public List<Actor> getActorsByPerformer(final PerformerRequestDto request) {
                
        if (request == null) {
            return null;
        }
        
        List<Actor> actors = this.performerService.getActorsByPerformer(request);
        return actors;
    }
    
    public List<Event> getEventsByPerformer(final PerformerRequestDto request) {
                
        if (request == null) {
            return null;
        }
        
        List<Event> events = this.performerService.getEventsByPerformer(request);
        return events;
    }
    
    public List<Instrument> getInstrumentsByPerformer(final PerformerRequestDto request) {
                
        if (request == null) {
            return null;
        }
        
        List<Instrument> instruments = this.performerService.getInstrumentsByPerformer(request);
        return instruments;
    }
    
    public List<Release> getEReleasesByPerformer(final PerformerRequestDto request) {
                
        if (request == null) {
            return null;
        }
        
        List<Release> releases = this.performerService.getEReleasesByPerformer(request);
        return releases;
    }
    
    public List<Location> getLocationsByPerformer(final PerformerRequestDto request) {
                
        if (request == null) {
            return null;
        }
        
        List<Location> locations = this.performerService.getLocationsByPerformer(request);
        return locations;
    }
    /* 
    * End INSTRUMENT service
    */
    /* 
    * Start RELEASE service
    */
    List<Release> getReleases(ReleaseRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Release> releases = this.releaseService.getReleases(request);
        return releases;
    }
    
    List<Performer> getPerformersByRelease(ReleaseRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Performer> performers = this.releaseService.getPerformersByRelease(request);
        return performers;
    }
    
    List<Actor> getActorsByRelease(ReleaseRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Actor> actors = this.releaseService.getActorsByRelease(request);
        return actors;
    }
    /* 
    * End RELEASE service
    */
    /* 
    * Start TICKET service
    */
    public List<Ticket> getTickets(final TicketRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Ticket> tickets = this.ticketService.getTickets(request);
        return tickets;
    }
    
    public List<Event> getEventsByTicket(final TicketRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Event> events = this.ticketService.getEventsByTicket(request);
        return events;
    }
    /* 
    * End TICKET service
    */
    /* 
    * Start LOCATION service
    */
    public List<Location> getLocations(final LocationRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Location> locations = this.locationService.getLocations(request);
        return locations;
    }
    
    public List<Event> getEventsByLocation(final LocationRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Event> events = this.locationService.getEventsByLocation(request);
        return events;
    }
        
    public List<Performer> getPerformersByLocation(final LocationRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Performer> performers = this.locationService.getPerformersByLocation(request);
        return performers;
    }
            
    public List<Actor> getActorsByLocation(final LocationRequestDto request) {
                        
        if (request == null) {
            return null;
        }
        
        List<Actor> actors = this.locationService.getActorsByLocation(request);
        return actors;
    }
    /* 
    * End LOCATION service
    */
    /* 
    * Start SPONSOR service
    */
    public List<Sponsor> getSponsors(SponsorRequestDto request) {
        
        if (request == null) {
            return null;
        }
        
        List<Sponsor> sponsors = this.sponsorService.getSponsors(request);
        return sponsors;
    }
    /* 
    * End SPONSOR service
    */
}
