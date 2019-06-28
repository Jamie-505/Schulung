package com.exxeta.rest;

import com.exxeta.entities.Training;
import com.exxeta.events.TrainingCreated;
import com.exxeta.interceptors.Perfomance;
import com.exxeta.repos.TrainingRepo;
import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@ApplicationScoped
@Path("/trainings")
@Log
@Perfomance
public class TrainingRestService {

    @Inject
    private TrainingRepo trainingRepo;

    @Inject @TrainingCreated
    private Event<Training> trainingEvent;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> findAllTrainings(@Context SecurityContext ctx){
        String userName = ctx.getUserPrincipal().getName();
        log.info("User name: " + userName);
        log.info("isAdmin? " + ctx.isUserInRole("super"));
        log.info("isUser? " + ctx.isUserInRole("user"));
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

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public boolean delete(@PathParam("id") Long id) {
        return trainingRepo.delete(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Training save(@Valid Training training) {
        boolean newTraining = training.getId() == null;
        trainingRepo.save(training);
        if (newTraining) {
            trainingEvent.fireAsync(training);
        }
        return training;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Training training) {
        trainingRepo.save(training);
        URI uri = null;
        try {
            uri = UriBuilder
                    .fromResource(TrainingRestService.class)
                    .path(TrainingRestService.class.getMethod("findById", Long.class))
                    .build(training.getId());
        } catch (NoSuchMethodException e) {
            log.log(Level.SEVERE, "Fehler bei Reflection: ", e);
        }
        return Response.created(uri).status(Response.Status.OK).build();
    }
}
