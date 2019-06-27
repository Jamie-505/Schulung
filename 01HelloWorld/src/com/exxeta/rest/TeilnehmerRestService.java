package com.exxeta.rest;

import com.exxeta.ejb.TeilnehmerRepo;
import com.exxeta.entities.Teilnehmer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Stateless
@Path("/teilnehmer")
public class TeilnehmerRestService {
    @EJB
    private TeilnehmerRepo teilnehmerRepo;

    @GET
    public List<Teilnehmer> findAll() {
        return teilnehmerRepo.findAll();
    }

    @GET
    @Path("{id}")
    public Teilnehmer findById(@PathParam("id") Long id) {
        return teilnehmerRepo.findById(id).orElse(new Teilnehmer());
    }
}
