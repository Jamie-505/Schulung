package com.exxeta;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TrainingRepo {
    @PersistenceContext
    private EntityManager em;

   public List<Training> findAll() {
       return em.createNamedQuery("Training.findAll", Training.class)
               .getResultList();
   }
}
