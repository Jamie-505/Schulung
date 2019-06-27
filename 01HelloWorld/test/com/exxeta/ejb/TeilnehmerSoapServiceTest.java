package com.exxeta.ejb;

import com.exxeta.ejb.client.Teilnehmer;
import com.exxeta.ejb.client.TeilnehmerSoapService;
import com.exxeta.ejb.client.TeilnehmerSoapServiceService;
import org.junit.jupiter.api.Test;

import java.util.List;

class TeilnehmerSoapServiceTest {

    @Test
    void findAllTeilnehmer() {
        TeilnehmerSoapServiceService service = new TeilnehmerSoapServiceService();
        TeilnehmerSoapService port = service.getTeilnehmerSoapServicePort();
        List<Teilnehmer> allTeilnehmer = port.findAllTeilnehmer();
        allTeilnehmer.forEach(System.out::println);
    }
}