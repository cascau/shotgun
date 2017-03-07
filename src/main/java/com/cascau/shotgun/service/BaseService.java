/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.dao.ActorDao;
import com.cascau.shotgun.dao.EventDao;
import com.cascau.shotgun.dao.InstrumentDao;
import com.cascau.shotgun.dao.LocationDao;
import com.cascau.shotgun.dao.PerformerDao;
import com.cascau.shotgun.dao.ReleaseDao;
import com.cascau.shotgun.dao.SponsorDao;
import com.cascau.shotgun.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class BaseService {
    
    @Autowired
    protected ActorDao actorDao;
    
    @Autowired
    protected EventDao eventDao;
    
    @Autowired
    protected InstrumentDao instrumentDao;
    
    @Autowired
    protected LocationDao locationDao;
    
    @Autowired
    protected PerformerDao performerDao;
    
    @Autowired
    protected ReleaseDao releaseDao;
    
    @Autowired
    protected SponsorDao sponsorDao;
    
    @Autowired
    protected TicketDao ticketDao;
}
