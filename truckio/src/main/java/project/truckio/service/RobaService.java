package project.truckio.service;

import project.truckio.model.Roba;

import java.util.List;
import java.util.Optional;

public interface RobaService {
    Roba addRoba(Integer roba_kolicina, Integer rezervacijaId, Integer kategorijaId);
    Optional<Roba> findById(Integer robaId);
    List<Roba> findAll();

    List<Roba> findRobaForReservation(Integer rezervacija_id);
}
