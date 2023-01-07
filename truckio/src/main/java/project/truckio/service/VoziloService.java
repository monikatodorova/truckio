package project.truckio.service;

import project.truckio.model.Vozilo;

import java.util.List;
import java.util.Optional;

public interface VoziloService {
    Vozilo registerVozilo(String vozilo_marka, Integer vozilo_kapacitet, Integer kompanijaId, Integer tipId, Integer vozacId);
    Optional<Vozilo> findById(Integer voziloId);
    List<Vozilo> findAll();
}
