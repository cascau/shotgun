/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

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
import java.sql.CallableStatement;
import java.sql.Connection;
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

            switch (rs.getInt("e.type")) {
                case 0 : {
                    return new GenericEvent(
                            rs.getLong("e.idevent"),
                            rs.getString("e.name"),
                            rs.getDate("e.startdt"),
                            rs.getDate("e.enddt"));
                }
                case 1 : {
                    return new Concert(
                            rs.getLong("e.idevent"),
                            rs.getString("e.name"),
                            rs.getDate("e.startdt"),
                            rs.getDate("e.enddt"));
                }
                case 2 : {
                    return new Festival(
                            rs.getLong("e.idevent"),
                            rs.getString("e.name"),
                            rs.getDate("e.startdt"),
                            rs.getDate("e.enddt"));
                }
                case 3 : {
                    return new Turneu(
                            rs.getLong("e.idevent"),
                            rs.getString("e.name"),
                            rs.getDate("e.startdt"),
                            rs.getDate("e.enddt"));
                }
                default : {
                    return new GenericEvent(
                            rs.getLong("e.idevent"),
                            rs.getString("e.name"),
                            rs.getDate("e.startdt"),
                            rs.getDate("e.enddt"));
                }
            }
        }
        
        public Performer buildBasicPerformer(ResultSet rs) throws SQLException {
            
            switch (rs.getInt("p.type")) {
                case 0 : {
                    return new GenericPerformer(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
                case 1 : {
                    return new Band(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
                case 2 : {
                    return new SoloPerformer(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
                case 3 : {
                    return new MiscPerformer(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
                case 4 : {
                    return new Orchestra(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
                default : {
                    return new GenericPerformer(
                            rs.getLong("p.idperformer"), 
                            rs.getString("p.name"));
                }
            }
        }
    }
}
