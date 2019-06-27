package com.exxeta.ejb;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@Log
public class HeartBeat {
    @PostConstruct
    public void init(){
        log.info("My Heart goes: ");
    }

    @Schedule(second = "*/1", minute = "*", hour = "*", persistent = false)
    public void beat() {
        log.info("Boom... Boom... Boom!");
    }
}
