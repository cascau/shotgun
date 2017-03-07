/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Ticket;
import com.cascau.shotgun.contract.dto.TicketRequestDto;
import com.cascau.shotgun.contract.event.Event;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class TicketService extends BaseService {
    
    public List<Ticket> getTickets(TicketRequestDto request) {
        
        return null;
    }
    
    public List<Event> getEventsByTicket(TicketRequestDto request) {
        
        return null;
    }
}
