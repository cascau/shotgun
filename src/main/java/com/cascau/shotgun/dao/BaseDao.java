/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.event.Concert;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.contract.event.Festival;
import com.cascau.shotgun.contract.event.GenericEvent;
import com.cascau.shotgun.contract.event.Turneu;
import com.cascau.shotgun.contract.performer.Band;
import com.cascau.shotgun.contract.performer.GenericPerformer;
import com.cascau.shotgun.contract.performer.MiscPerformer;
import com.cascau.shotgun.contract.performer.Orchestra;
import com.cascau.shotgun.contract.performer.Performer;
import com.cascau.shotgun.contract.performer.SoloPerformer;
import com.cascau.shotgun.util.Utilities;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class BaseDao implements StoredProcedures {
        
    @Autowired
    private DataSource dataSource;

    private Connection connection = null;
    
    public Connection getConnection() throws SQLException {
        
        if (connection == null) {
            connection = this.getDataSource().getConnection();
        }
        return connection;
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    protected BuilderFactory builderFactory = new BuilderFactory();
    
    public CallableStatement createCallableStatement(String sqlQuery) throws SQLException {
        
        CallableStatement cs = this.getConnection().prepareCall(sqlQuery);
        
        return cs;
    }
    
    protected class BuilderFactory {
  
        public Event buildBasicEvent(ResultSet rs) throws SQLException {

            Long eventId = rs.getLong("e.idevent");
            String eventName = rs.getString("e.name");
            Date eventStart = rs.getDate("e.startdt");
            Date eventEnd = rs.getDate("e.enddt");
            
            switch (rs.getInt("e.type")) {
                case 0 : {
                    return new GenericEvent(eventId, eventName, eventStart, eventEnd);
                }
                case 1 : {
                    return new Concert(eventId, eventName, eventStart, eventEnd);
                }
                case 2 : {
                    return new Festival(eventId, eventName, eventStart, eventEnd);
                }
                case 3 : {
                    return new Turneu(eventId, eventName, eventStart, eventEnd);
                }
                default : {
                    return new GenericEvent(eventId, eventName, eventStart, eventEnd);
                }
            }
        }
        
        public Performer buildBasicPerformer(ResultSet rs) throws SQLException {
            
            Long idPerformer = rs.getLong("p.idperformer");
            String performerName = rs.getString("p.name");
            
            switch (rs.getInt("p.type")) {
                case 0 : {
                    return new GenericPerformer(idPerformer, performerName);
                }
                case 1 : {
                    return new Band(idPerformer, performerName);
                }
                case 2 : {
                    return new SoloPerformer(idPerformer, performerName);
                }
                case 3 : {
                    return new MiscPerformer(idPerformer, performerName);
                }
                case 4 : {
                    return new Orchestra(idPerformer, performerName);
                }
                default : {
                    return new GenericPerformer(idPerformer, performerName);
                }
            }
        }
        
        public Location buildLocation(final ResultSet rs) throws SQLException {
            
            Location loc = new Location();
            
            loc.setId(rs.getLong("l.idlocation"));
            loc.setName(rs.getString("l.name"));
            loc.setAddress(rs.getString("l.address"));
            loc.setCountry(rs.getString("l.country"));
            loc.setGpsCoords(Utilities.getGPSCoordsFromSimpleString(rs.getString("l.gpscoords")));
            
            return loc;
        }
    }
}
