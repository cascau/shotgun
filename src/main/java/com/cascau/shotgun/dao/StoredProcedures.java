/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cascau.shotgun.dao;

/**
 *
 * @author cascau
 */
public interface StoredProcedures {

    public interface Events {
        static final String GET_EVENTS_NOID_NO_DATES = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" + 
                "order by e.idevent";
        static final String GET_EVENTS_NOID_BOTH_DATES = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.startdt >= ? and e.enddt <= ? \n" + 
                "order by e.idevent";
        static final String GET_EVENTS_NOID_START_DATE = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.startdt >= ? \n" + 
                "order by e.idevent asc";
        static final String GET_EVENTS_NOID_END_DATE = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.enddt <= ? \n" + 
                "order by e.idevent asc";
        static final String GET_EVENTS_ID_NO_DATES = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.idevent = ? \n" + 
                "order by e.idevent asc";
        static final String GET_EVENTS_ID_START_DATE = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.idevent = ? \n" +
                "and e.startdt >= ? \n" + 
                "order by e.idevent asc";
        static final String GET_EVENTS_ID_END_DATE = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.idevent = ? \n" +
                "and e.enddt <= ? \n" + 
                "order by e.idevent";
        static final String GET_EVENTS_ID_BOTH_DATES = 
                "select e.idevent, e.name, e.type, e.startdt, e.enddt \n" +
                "from shotgun.event e \n" +
                "where e.idevent = ? \n" +
                "and e.startdt >= ? \n" +
                "and e.enddt <= ? \n" + 
                "order by e.idevent asc";
    }
    
    public interface Performers {
        static final String GET_PERFORMERS_BY_EVENT =
                "select p.idperformer, p.name, p.type from shotgun.performer p\n" +
                "inner join shotgun.performer_event pe on p.idperformer = pe.idperformer\n" +
                "where pe.idevent = ? \n" +
                "order by p.idperformer asc";
    }
}
