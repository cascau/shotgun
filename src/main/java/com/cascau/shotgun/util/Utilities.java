/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cascau
 */
public class Utilities {

    public static final String SIMPLE_GPS_REGEX = "([-0-9\\.])+ ([-0-9\\.])+"; //-0.18505 51.51107 
    
    public static List<Long> getGPSCoordsFromSimpleString(String input) {
        
        List<Long> result = new ArrayList<>();
        
        try {
            String[] coords = input.split(" ");
            result.set(0, Long.parseLong(coords[0]));
            result.set(1, Long.parseLong(coords[1]));
        } catch (NumberFormatException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
