package com.exxeta.repos;

import com.exxeta.entities.Teilnehmer;
import com.exxeta.entities.Trainer;
import com.exxeta.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DbInit {
    @PersistenceContext
    private EntityManager em;

    @Inject @TestData
    private List<Training> trainings;

    @Inject @TestData
    private List<Teilnehmer> teilnehmer;

    @Inject @TestData
    private List<Trainer> trainer;

    @Transactional
    public void initDb(@Observes @Initialized(ApplicationScoped.class) Object event){
        List<Training> existingTrainings = em.createNamedQuery("Training.findAll", Training.class)
                .setMaxResults(1)
                .getResultList();

        if (existingTrainings.isEmpty()) {

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
