package com.exxeta.repos;

import com.exxeta.entities.SkillLevel;
import com.exxeta.entities.Teilnehmer;
import com.exxeta.entities.Trainer;
import com.exxeta.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@ApplicationScoped
public class TestDataProducer {
    @Produces
    @TestData
    public List<Training> producesTraining() {
        return LongStream.range(0, 100)
                .mapToObj(i -> Training.builder()
                        .name("Training" + i)
                        .build())
                .collect(Collectors.toList());
    }

    @Produces
    @TestData
    public List<Teilnehmer> producesTeilnehmer(){
        return LongStream.range(0, 10)
                .mapToObj(i -> Teilnehmer.builder().name("Teilnehmer" + i).geburtsdatum(new Date()).build())
                .collect(Collectors.toList());
    }

    @Produces
    @TestData
    public List<Trainer> producesTrainer(){
        Trainer trainerMichael = Trainer.builder()
                .name("Michael")
                .skillLevel(SkillLevel.A)
                .build();
        Trainer trainerBernhard = Trainer.builder()
                .name("Bernhard")
                .skillLevel(SkillLevel.B)
                .build();
        List<Trainer> trainer = Arrays.asList(trainerMichael, trainerBernhard);
        return trainer;
    }
}
