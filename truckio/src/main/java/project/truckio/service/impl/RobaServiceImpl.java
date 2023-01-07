package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Kategorija;
import project.truckio.model.Rezervacija;
import project.truckio.model.Roba;
import project.truckio.repository.KategorijaRepository;
import project.truckio.repository.RezervacijaRepository;
import project.truckio.repository.RobaRepository;
import project.truckio.service.RobaService;

import java.util.List;
import java.util.Optional;

@Service
public class RobaServiceImpl implements RobaService {

    private final RobaRepository robaRepository;
    private final RezervacijaRepository rezervacijaRepository;
    private final KategorijaRepository kategorijaRepository;

    public RobaServiceImpl(RobaRepository robaRepository, RezervacijaRepository rezervacijaRepository, KategorijaRepository kategorijaRepository) {
        this.robaRepository = robaRepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public Roba addRoba(Integer roba_kolicina, Integer rezervacijaId, Integer kategorijaId) {
        Rezervacija rezervacija = rezervacijaRepository.findById(rezervacijaId).get();
        Kategorija kategorija = kategorijaRepository.findById(kategorijaId).get();
        Roba roba = new Roba(roba_kolicina, rezervacija, kategorija);

        return robaRepository.save(roba);
    }

    @Override
    public Optional<Roba> findById(Integer robaId) {
        return robaRepository.findById(robaId);
    }

    @Override
    public List<Roba> findAll() {
        return robaRepository.findAll();
    }
}
