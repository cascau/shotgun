/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.Location;
import com.cascau.shotgun.contract.dto.BaseRequestDto;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class LocationDao extends BaseDao {
    
    public List<Location> getLocations(BaseRequestDto request) {
        
        return null;
    }
}
