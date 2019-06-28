package com.exxeta;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
@Log
public class ApplicationProperties {
    private Properties props = new Properties();

    @PostConstruct
    public void init(){
        try {
            InputStream resourceAsStream =
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
            props.load(resourceAsStream);
            log.info("+++++++++++++++++++++++++++++++++");
            props.forEach((k,v) -> log.info(k + "=" + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Produces @Named("log.heartbeat")
    public Boolean isLogHeartbeat() {
        String isLogHeartBeatString = props.getProperty("log.heartbeat", "false");
        return Boolean.valueOf(isLogHeartBeatString);
    }


}
