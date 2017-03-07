/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cascau
 */
@Controller
public class ToursController {
    
    @RequestMapping("/tours")
    public String doTours() {
        
        return "tour/tours";
    }
}
