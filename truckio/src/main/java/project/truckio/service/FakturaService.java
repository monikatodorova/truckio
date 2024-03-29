package project.truckio.service;

import project.truckio.model.Faktura;
import project.truckio.model.Rezervacija;

import java.util.List;
import java.util.Optional;

public interface FakturaService {
    Faktura addFaktura(Integer faktura_iznos, Integer rezervacijaId, Integer administratorId);
    Optional<Faktura> findById(Integer fakturaId);
    List<Faktura> findAll();
    Faktura findFakturaByRezervacija(Rezervacija rezervacija);
}
