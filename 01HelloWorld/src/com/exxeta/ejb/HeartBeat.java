package com.exxeta.ejb;

import com.exxeta.websocket.MyWebSocket;
import lombok.extern.java.Log;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@Log
public class HeartBeat {
    public void init(){
        log.info("My Heart goes: ");
    }

    @Inject
    private MyWebSocket myWebSocket;

    public void beat() {
        myWebSocket.incrementCounter();
        log.info("Boom... Boom... Boom!");
    }
}
