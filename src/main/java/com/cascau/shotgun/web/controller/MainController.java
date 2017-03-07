/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.web.controller;

import com.cascau.shotgun.contract.dto.EventRequestDto;
import com.cascau.shotgun.contract.event.Event;
import com.cascau.shotgun.service.ServiceProvider;
import com.cascau.shotgun.util.ControllerUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cascau
 */
@Controller
public class MainController {

    protected static final String VIEW_NAME = "welcome";
    
    @Autowired
    private ServiceProvider serviceProvider;
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String helloWorld(final HttpSession httpSession, 
            final HttpServletRequest httpRequest, final HttpServletResponse httpResponse,
            final Model model) {
        
        EventRequestDto noIdNoDate = ControllerUtil.noIdNoDate(httpRequest);
        List<Event> events = this.serviceProvider.getEvents(noIdNoDate);
        model.addAttribute("events", events);
        
        return VIEW_NAME;
    }    
 
}
