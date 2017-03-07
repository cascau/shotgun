/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.dto.BaseRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.dto.EventRequestDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class EventDao extends BaseDao {

    public List<Event> getEvents(final BaseRequestDto request) throws SQLException {

        
        List<Event> events = new ArrayList<>();
        String sql;
        
        boolean hasIds = false, hasStartdt = false, hasEnddt = false;
        if (request.getId() != null && !request.getId().equals(0L)) {
            hasIds = true;
        }
        if (request.getStartdt() != null) {
            hasStartdt = true;
        }
        if (request.getEnddt() != null) {
            hasEnddt = true;
        }
        
        if (hasIds) {
            if (hasStartdt) {
                if (hasEnddt) {
                    sql = StoredProcedures.Events.GET_EVENTS_ID_BOTH_DATES;
                } else {
                    sql = StoredProcedures.Events.GET_EVENTS_ID_START_DATE;
                } 
            } else if (hasEnddt) {
                sql = StoredProcedures.Events.GET_EVENTS_ID_END_DATE;
            } else {
                sql = StoredProcedures.Events.GET_EVENTS_ID_NO_DATES;
            }
        } else 
            if (hasStartdt) {
                if (hasEnddt) {
                    sql = StoredProcedures.Events.GET_EVENTS_NOID_BOTH_DATES;
                } else {
                    sql = StoredProcedures.Events.GET_EVENTS_NOID_START_DATE;
                } 
            } else if (hasEnddt) {
                sql = StoredProcedures.Events.GET_EVENTS_NOID_END_DATE;
            } else {
                sql = StoredProcedures.Events.GET_EVENTS_NOID_NO_DATES;
        }
        
        try (CallableStatement cs = this.createCallableStatement(sql)) {
            switch (sql) {
                case StoredProcedures.Events.GET_EVENTS_ID_BOTH_DATES : {
                    
                    cs.setLong(1, request.getId());
                    cs.setDate(2, request.getStartdt());
                    cs.setDate(3, request.getEnddt());
                    break;
                }
                case StoredProcedures.Events.GET_EVENTS_ID_START_DATE : {
                    
                    cs.setLong(1, request.getId());
                    cs.setDate(2, request.getStartdt());
                    break;
                }
                
                case StoredProcedures.Events.GET_EVENTS_ID_END_DATE : {
                                        
                    cs.setLong(1, request.getId());
                    cs.setDate(2, request.getEnddt());
                    break;
                }
                
                case StoredProcedures.Events.GET_EVENTS_ID_NO_DATES : {
                                    
                    cs.setLong(1, request.getId());
                    break;
                }
                
                case StoredProcedures.Events.GET_EVENTS_NOID_BOTH_DATES : {
                    
                    cs.setDate(1, request.getStartdt());
                    cs.setDate(2, request.getEnddt());
                    break;
                }
                
                case StoredProcedures.Events.GET_EVENTS_NOID_START_DATE : {
                    
                    cs.setDate(1, request.getStartdt());
                    break;
                }
                
                case StoredProcedures.Events.GET_EVENTS_NOID_END_DATE : {
                    
                    cs.setDate(1, request.getEnddt());
                    break;
                }
                case StoredProcedures.Events.GET_EVENTS_NOID_NO_DATES : {
                    
                    break;
                }
                default : {
                    
                }
            }
            
            boolean hasResults = cs.execute();
            while (hasResults) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    events.add(this.builderFactory.buildBasicEvent(rs));
                }
                hasResults = cs.getMoreResults();
            }
        }
        
        return events;
    }
}
