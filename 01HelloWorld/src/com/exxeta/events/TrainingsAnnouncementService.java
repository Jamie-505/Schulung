package com.exxeta.events;

import com.exxeta.entities.Training;
import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
@Log
public class TrainingsAnnouncementService {
    public void receiveTrainingCreated(@ObservesAsync @TrainingCreated Training training) {
        log.info("Announcing Training: " + training);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
