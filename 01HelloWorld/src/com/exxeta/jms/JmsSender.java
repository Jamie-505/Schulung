package com.exxeta.jms;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@ApplicationScoped
public class JmsSender {
    @Inject
    JMSContext context;

    @Resource(lookup = "java:/jms/topic/training")
    private Topic trainingTopic;

    public void sendMessage(String message){
        context.createProducer().send(trainingTopic, message);
    }
}
