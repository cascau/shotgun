/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.service;

import com.cascau.shotgun.contract.Actor;
import com.cascau.shotgun.contract.dto.InstrumentRequestDto;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cascau
 */
@Component
public class InstrumentService extends BaseService {
    
    public List<Actor> getActorsByInstrument(InstrumentRequestDto request) {
        
        return null;
    }
}
