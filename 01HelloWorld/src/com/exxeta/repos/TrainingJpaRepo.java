package com.exxeta.repos;

import com.exxeta.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Alternative
@ApplicationScoped
public class TrainingJpaRepo implements TrainingRepo {
    @PersistenceContext
    private EntityManager em;

   @Override
   public List<Training> findAllFetchTeilnehmer() {
       return em.createNamedQuery("Training.findAllFetchTeilnehmer", Training.class)
               .getResultList();
   }

   @Override
   public List<Training> findAll() {
       TypedQuery<Training> query = em.createNamedQuery("Training.findAll", Training.class);
       EntityGraph<?> entityGraph = em.createEntityGraph("Training.allAttributes");
       query.setHint("javax.persistence.loadgraph", entityGraph);
       List<Training> trainings = query.getResultList();
       return trainings;
    }

    @Override
    public Optional<Training> findById(Long id) {
       return Optional.ofNullable(em.find(Training.class, id));
    }

    @Override
    public List<Training> findByName(String name) {
       TypedQuery<Training> query = em.createQuery("select t from Training t where t.name like :name", Training.class);
       query.setParameter("name", name + "%");
       query.setMaxResults(100);
       return query.getResultList();
    }

    @Override
    @Transactional
    public Training save(Training training) {
       return em.merge(training);
    }

   @Override
   @Transactional
   public boolean delete(Long id) {
       Optional<Training> trainingOpt = findById(id);
           if (trainingOpt.isPresent()) {
               em.remove(trainingOpt.get());
               return true;
           } else {
               return false;
           }

   }

   @Override
   @Transactional
    public boolean delete(Training training) {
       return delete(training.getId());
   }
}
