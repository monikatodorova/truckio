package project.truckio.service;

import project.truckio.model.Rezervacija;

import java.util.List;
import java.util.Optional;

public interface RezervacijaService {
    Rezervacija addRezervacija(String rezervacija_status, Integer klientId, Integer rutaId);
    Optional<Rezervacija> findById(Integer rezervacijaId);
    List<Rezervacija> findAll();
    List<Rezervacija> findMyReservations(Integer klient_id);
}
