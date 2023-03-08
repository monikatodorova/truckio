package project.truckio.service;

import project.truckio.model.Ruta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RutaService {
    Ruta addRuta(LocalDate datum_poagjanje, LocalDate datum_pristiganje, Integer zapocnuvaVoId, Integer zavrsuvaVoId, Integer voziloId, Integer dispecerId, Integer vozacId);
    Ruta findById(Integer rutaId);
    List<Ruta> findAll();
    List<Ruta> findAllByCompany(Integer kompanijaId);
    List<Ruta> findAllAvailable();
    List<Ruta> findAllActiveByVozac(Integer vozac_id);
    List<Ruta> findAllActiveByDispecer(Integer dispecer_id);

    List<Ruta> findAllInDateInterval(LocalDate from, LocalDate to);
}
