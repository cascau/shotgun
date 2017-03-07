/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.dto.BaseRequestDto;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class ActorDao extends BaseDao {
    
    public List<Actor> getActors(BaseRequestDto request) {
        
        return null;
    }
}
