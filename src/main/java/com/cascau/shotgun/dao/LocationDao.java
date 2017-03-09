/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.dto.BaseRequestDto;
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
public class LocationDao extends BaseDao {
    
    public List<Location> getLocations(BaseRequestDto request) throws SQLException {
        
        if (request == null || request.getId() == null) {
            return null;
        }
        
        List<Location> locations = new ArrayList<>(); 
        try (CallableStatement cs = this.createCallableStatement(StoredProcedures.Locations.GET_LOCATIONS)) {
            cs.setLong(1, request.getId());
            boolean hasResults = cs.execute();
            while (hasResults) {                
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    locations.add(this.builderFactory.buildLocation(rs));
                }
                hasResults = cs.getMoreResults();
            }
        }
        return locations;
    }
    
    public List<Location> getLocationsByEventId(BaseRequestDto request) throws SQLException {
        
        if (request == null || request.getId() == null) {
            return null;
        }
        
        List<Location> locations = new ArrayList<>(); 
        try (CallableStatement cs = this.createCallableStatement(StoredProcedures.Locations.GET_LOCATIONS_BY_EVENT_ID)) {
            cs.setLong(1, request.getId());
            boolean hasResults = cs.execute();
            while (hasResults) {                
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    locations.add(this.builderFactory.buildLocation(rs));
                }
                hasResults = cs.getMoreResults();
            }
        }
        return locations;
    }
}
