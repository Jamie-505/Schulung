package com.exxeta;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
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
            LongStream.range(0, 100)
                    .mapToObj(i -> Training.builder().name("Training" + i).build())
                    .forEach(t -> em.persist(t));
        }
    }
}
