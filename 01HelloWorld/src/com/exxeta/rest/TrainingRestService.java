package com.exxeta.rest;

import com.exxeta.entities.Training;
import com.exxeta.repos.TrainingRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/trainings")
public class TrainingRestService {
    @Inject
    private TrainingRepo trainingRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> findAllTrainings(){
        return trainingRepo.findAllFetchTeilnehmer();
    }
}
