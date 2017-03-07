/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class BaseServiceProvider {
    
    @Autowired
    protected ActorService actorService;
    
    @Autowired
    protected EventService eventService;
    
    @Autowired
    protected InstrumentService instrumentService;
    
    @Autowired
    protected LocationService locationService;
    
    @Autowired
    protected PerformerService performerService;
    
    @Autowired
    protected ReleaseService releaseService;
    
    @Autowired
    protected SponsorService sponsorService;
    
    @Autowired
    protected TicketService ticketService;
}
