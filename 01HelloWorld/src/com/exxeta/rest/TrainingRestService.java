package com.exxeta.rest;

import com.exxeta.entities.Training;
import com.exxeta.repos.TrainingRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Path("/trainings")
public class TrainingRestService {
    @Inject
    private TrainingRepo trainingRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> findAllTrainings(){
        return trainingRepo.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Training> trainingOptional = trainingRepo.findById(id);
        if (trainingOptional.isPresent()) {
            return Response.ok(trainingOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
