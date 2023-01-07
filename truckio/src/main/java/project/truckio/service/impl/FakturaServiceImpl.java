package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Administrator;
import project.truckio.model.Faktura;
import project.truckio.model.Rezervacija;
import project.truckio.repository.AdministratorRepository;
import project.truckio.repository.FakturaRepository;
import project.truckio.repository.RezervacijaRepository;
import project.truckio.service.FakturaService;

import java.util.List;
import java.util.Optional;

@Service
public class FakturaServiceImpl implements FakturaService {

    private final FakturaRepository fakturaRepository;
    private final RezervacijaRepository rezervacijaRepository;
    private final AdministratorRepository administratorRepository;

    public FakturaServiceImpl(FakturaRepository fakturaRepository, RezervacijaRepository rezervacijaRepository, AdministratorRepository administratorRepository) {
        this.fakturaRepository = fakturaRepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Faktura addFaktura(Integer faktura_iznos, Integer rezervacijaId, Integer administratorId) {
        Rezervacija rezervacija = rezervacijaRepository.findById(rezervacijaId).get();
        Administrator administrator = administratorRepository.findById(administratorId).get();
        Faktura faktura = new Faktura(faktura_iznos, rezervacija, administrator);
        return fakturaRepository.save(faktura);
    }

    @Override
    public Optional<Faktura> findById(Integer fakturaId) {
        return fakturaRepository.findById(fakturaId);
    }

    @Override
    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }
}
