package com.exxeta.websocket;

import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

@ApplicationScoped
@Log
@ServerEndpoint("/ws/counter")
public class MyWebSocket {
    private AtomicInteger counter = new AtomicInteger(0);
    private List<Session> sessions = Collections.synchronizedList(new ArrayList<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
        log.log(Level.SEVERE, "Fehler im Websocket", error);
    }

    @OnMessage
    public void onMessage(String msg) {
        if (msg.equals("reset")) {
            counter.set(0);
        }
    }

    public void incrementCounter() {
        counter.incrementAndGet();
        Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            try {
                iterator.next().getBasicRemote().sendText(counter.toString());
            } catch (IOException e) {
                iterator.remove();
            }
        }
    }

}
