package com.exxeta.repos;

import com.exxeta.entities.SkillLevel;
import com.exxeta.entities.Teilnehmer;
import com.exxeta.entities.Trainer;
import com.exxeta.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@ApplicationScoped
public class DbInit {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void initDb(@Observes @Initialized(ApplicationScoped.class) Object event){
        List<Training> existingTrainings = em.createNamedQuery("Training.findAll", Training.class)
                .setMaxResults(1)
                .getResultList();

        if (existingTrainings.isEmpty()) {
            List<Training> trainings = LongStream.range(0, 100)
                    .mapToObj(i -> Training.builder()
                            .name("Training" + i)
                            .build())
                    .collect(Collectors.toList());

            List<Teilnehmer> teilnehmer = LongStream.range(0, 10)
                    .mapToObj(i -> Teilnehmer.builder().name("Teilnehmer" + i).geburtsdatum(new Date()).build())
                    .collect(Collectors.toList());

            Trainer trainerMichael = Trainer.builder()
                    .name("Michael")
                    .skillLevel(SkillLevel.A)
                    .build();
            Trainer trainerBernhard = Trainer.builder()
                    .name("Bernhard")
                    .skillLevel(SkillLevel.B)
                    .build();
            List<Trainer> trainer = Arrays.asList(trainerMichael, trainerBernhard);

            trainer.forEach(t -> em.persist(t));
            teilnehmer.forEach(t -> em.persist(t));

            for (int i = 0; i < trainings.size(); i++) {
                Training training = trainings.get(i);
                training.setTrainer(trainer.get(i%2));
                training.setTeilnehmer(teilnehmer);
                em.persist(training);
            }
        }
    }
}
