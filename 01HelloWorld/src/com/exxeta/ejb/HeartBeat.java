package com.exxeta.ejb;

import com.exxeta.websocket.MyWebSocket;
import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@Log
public class HeartBeat {
    @PostConstruct
    public void init(){
        log.info("My Heart goes: ");
    }

    @Inject
    private MyWebSocket myWebSocket;

    @Schedule(second = "*/1", minute = "*", hour = "*", persistent = false)
    public void beat() {
        myWebSocket.incrementCounter();
        log.info("Boom... Boom... Boom!");
    }
}
