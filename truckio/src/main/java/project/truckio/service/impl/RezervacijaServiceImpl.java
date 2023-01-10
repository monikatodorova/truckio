package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Klient;
import project.truckio.model.Rezervacija;
import project.truckio.model.Ruta;
import project.truckio.repository.KlientRepository;
import project.truckio.repository.RezervacijaRepository;
import project.truckio.repository.RutaRepository;
import project.truckio.service.RezervacijaService;

import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {

    private final RezervacijaRepository rezervacijaRepository;
    private final KlientRepository klientRepository;
    private final RutaRepository rutaRepository;

    public RezervacijaServiceImpl(RezervacijaRepository rezervacijaRepository, KlientRepository klientRepository, RutaRepository rutaRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.klientRepository = klientRepository;
        this.rutaRepository = rutaRepository;
    }

    @Override
    public Rezervacija addRezervacija(String rezervacija_status, Integer klientId, Integer rutaId) {
        Klient klient = klientRepository.findById(klientId).get();
        Ruta ruta = rutaRepository.findById(rutaId).get();
        Rezervacija rezervacija = new Rezervacija(rezervacija_status, klient, ruta);
        return rezervacijaRepository.save(rezervacija);
    }

    @Override
    public Rezervacija findById(Integer rezervacijaId) {
        return rezervacijaRepository.findById(rezervacijaId).get();
    }

    @Override
    public List<Rezervacija> findAll() {
        return rezervacijaRepository.findAll();
    }

    @Override
    public List<Rezervacija> findMyReservations(Integer klient_id) {
        return rezervacijaRepository.findMyReservations(klient_id);
    }

    @Override
    public List<Rezervacija> findReservationsForRoute(Integer ruta_id) {
        return rezervacijaRepository.findReservationsForRoute(ruta_id);
    }

    @Override
    public List<Rezervacija> finAllRezervaciiByCompany(Integer kompanija_id) {
        return rezervacijaRepository.findAllReservationsByCompany(kompanija_id);
    }

    @Override
    public List<Rezervacija> findByRuta(Integer ruta_id) {
        return this.rezervacijaRepository.findByRuta(ruta_id);
    }
}
