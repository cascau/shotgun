/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.util;

import com.cascau.shotgun.contract.dto.EventRequestDto;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cascau
 */
public class ControllerUtil {

    public static EventRequestDto idBothDates(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        request.setId(1L);
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 1);
        Date start = new Date(cal.getTimeInMillis());
        request.setStartdt(start);
        cal.set(2018, 1, 1);
        Date end = new Date(cal.getTimeInMillis());
        request.setEnddt(end);

        return request;
    }

    public static EventRequestDto idStartDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        request.setId(1L);
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 1);
        Date start = new Date(cal.getTimeInMillis());
        request.setStartdt(start);

        return request;
    }

    public static EventRequestDto idEndDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        request.setId(1L);
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 1, 1);
        Date end = new Date(cal.getTimeInMillis());
        request.setEnddt(end);

        return request;
    }

    public static EventRequestDto idNoDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        request.setId(1L);
        
        return request;
    }

    public static EventRequestDto noIdBothDates(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 1);
        Date start = new Date(cal.getTimeInMillis());
        request.setStartdt(start);
        cal.set(2018, 1, 1);
        Date end = new Date(cal.getTimeInMillis());
        request.setEnddt(end);

        return request;
    }

    public static EventRequestDto noIdStartDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 1);
        Date start = new Date(cal.getTimeInMillis());
        request.setStartdt(start);

        return request;
    }

    public static EventRequestDto noIdEndDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 1, 1);
        Date end = new Date(cal.getTimeInMillis());
        request.setEnddt(end);

        return request;
    }

    public static EventRequestDto noIdNoDate(final HttpServletRequest httpRequest) {

        EventRequestDto request = new EventRequestDto();

        return request;
    }
}
