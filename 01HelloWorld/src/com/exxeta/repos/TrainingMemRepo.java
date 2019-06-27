package com.exxeta.repos;

import com.exxeta.entities.Training;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Alternative
@ApplicationScoped
public class TrainingMemRepo implements TrainingRepo {
    private Map<Long, Training> trainingMap = Collections.synchronizedMap(new HashMap<>());
    private AtomicLong nextId = new AtomicLong(1L);

    @Override
    public List<Training> findAllFetchTeilnehmer() {
        return trainingMap.values()
                .stream()
                .sorted(Comparator.comparing(Training::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Training> findAll() {
        return trainingMap.values()
                .stream()
                .sorted(Comparator.comparing(Training::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Training> findById(Long id) {
        return Optional.ofNullable(trainingMap.get(id));
    }

    @Override
    public List<Training> findByName(String name) {
        return trainingMap.values()
                .stream()
                .filter(t -> t.getName().toLowerCase().startsWith(name.toLowerCase()))
                .sorted(Comparator.comparing(Training::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Training save(Training training) {
        if(training.getId() == null) {
            training.setId(nextId.getAndIncrement());
        }
        trainingMap.put(training.getId(), training);
        return training;
    }

    @Override
    public boolean delete(Long id) {
        return trainingMap.remove(id) != null;
    }

    @Override
    public boolean delete(Training training) {
        return delete(training.getId());
    }
}
