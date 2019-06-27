package com.exxeta.ejb;

import com.exxeta.entities.Teilnehmer;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public interface TeilnehmerRepo {
    List<Teilnehmer> findAll();
    Optional<Teilnehmer> findById(Long id);
}
