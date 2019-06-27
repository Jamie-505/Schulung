package com.exxeta.ejb;

import com.exxeta.entities.Teilnehmer;
import com.exxeta.interceptors.Perfomance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
@Perfomance
public class TeilnehmerJpaRepo implements TeilnehmerRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Teilnehmer> findAll() {
        return em.createQuery("select t from Teilnehmer t order by t.name", Teilnehmer.class).getResultList();
    }

    @Override
    public Optional<Teilnehmer> findById(Long id) {
        return Optional.ofNullable(em.find(Teilnehmer.class, id));
    }
}
