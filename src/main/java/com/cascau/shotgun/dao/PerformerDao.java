/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.dto.BaseRequestDto;
import com.cascau.shotgun.contract.performer.Performer;
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
public class PerformerDao extends BaseDao {
    
    public List<Performer> getPerformersByActor(BaseRequestDto request) {
        
        return null;
    }
    
    public List<Performer> getPerformersByEvent(BaseRequestDto request) throws SQLException {
        
        if (request == null || request.getId() == null) {
            return null;
        }
        return this.getPerformersByEventId(request.getId());
    }
    
    private List<Performer> getPerformersByEventId(Long eventId) throws SQLException {
        
        List<Performer> performers = new ArrayList<>();        
        try (CallableStatement cs = this.createCallableStatement(StoredProcedures.Performers.GET_PERFORMERS_BY_EVENT)) {
            cs.setLong(1, eventId);
            boolean hasResults = cs.execute();
            while (hasResults) {                
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    performers.add(this.builderFactory.buildBasicPerformer(rs));
                }
                hasResults = cs.getMoreResults();
            }
        }
        return performers;
    }
}
