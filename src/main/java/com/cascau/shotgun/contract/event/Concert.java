/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.contract.event;

import java.sql.Date;

/**
 *
 * @author cascau
 */
public class Concert extends Event {
    
    public Concert(Long id, String name) {
        super(id, name);
    }
    
    public Concert(Long id, String name, Date startdt, Date enddt) {
        super(id, name, startdt, enddt);
    }
}
