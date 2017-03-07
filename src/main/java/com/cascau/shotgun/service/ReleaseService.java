/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.Release;
import com.cascau.shotgun.contract.dto.ReleaseRequestDto;
import com.cascau.shotgun.contract.performer.Performer;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class ReleaseService extends BaseService {
    
    List<Release> getReleases(ReleaseRequestDto request) {
        
        return null;
    }
    
    List<Performer> getPerformersByRelease(ReleaseRequestDto request) {
        
        return null;
    }
    
    List<Actor> getActorsByRelease(ReleaseRequestDto request) {
        
        return null;
    }
}
