package project.truckio.service;

import project.truckio.model.Ruta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RutaService {
    Ruta addRuta(LocalDate datum_poagjanje, LocalDate datum_pristiganje, Integer zapocnuvaVoId, Integer zavrsuvaVoId, Integer voziloId, Integer dispecerId, Integer vozacId);
    Ruta findById(Integer rutaId);
    List<Ruta> findAll();
    List<Ruta> findAllAvailable();
}
