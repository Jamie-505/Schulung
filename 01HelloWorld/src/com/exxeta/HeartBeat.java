package com.exxeta;

import com.exxeta.websocket.MyWebSocket;
import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;

@Singleton
@Startup
@Log
public class HeartBeat {
    @PostConstruct
    public void init(){
        log.info("My Heart goes: ");
    }

    @Inject @Named("log.heartbeat")
    private Boolean isLogHeartbeat;

    @Inject
    private MyWebSocket myWebSocket;

   @Schedule(second = “*/1”, minute = “*”, hour =“*”, persistent = true)
    public void beat() {
        if (isLogHeartbeat) {
            myWebSocket.incrementCounter();
            log.info("Boom... Boom... Boom!");
        }
    }
}
