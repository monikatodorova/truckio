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
    public Optional<Rezervacija> findById(Integer rezervacijaId) {
        return rezervacijaRepository.findById(rezervacijaId);
    }

    @Override
    public List<Rezervacija> findAll() {
        return rezervacijaRepository.findAll();
    }
}
