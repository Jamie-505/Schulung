package com.exxeta.repos;

import com.exxeta.entities.Training;
import com.exxeta.interceptors.Perfomance;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Perfomance
public interface TrainingRepo {
    List<Training> findAllFetchTeilnehmer();

    List<Training> findAll();

    Optional<Training> findById(Long id);

    List<Training> findByName(String name);

    @Transactional
    Training save(Training training);

    @Transactional
    boolean delete(Long id);

    @Transactional
    default boolean delete(Training training) {
        return delete(training.getId());
    }
}
