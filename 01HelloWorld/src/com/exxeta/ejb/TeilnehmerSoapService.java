package com.exxeta.ejb;

import com.exxeta.entities.Teilnehmer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class TeilnehmerSoapService {
    @Inject
    private TeilnehmerRepo teilnehmerRepo;

    public List<Teilnehmer> findAllTeilnehmer(){
        return teilnehmerRepo.findAll();
    }

    public Teilnehmer findTeilnehmerById(Long id) {
        return teilnehmerRepo.findById(id).orElse(null);
    }
}
