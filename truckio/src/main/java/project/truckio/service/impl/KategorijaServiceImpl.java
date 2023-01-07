package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Kategorija;
import project.truckio.repository.KategorijaRepository;
import project.truckio.service.KategorijaService;

import java.util.List;
import java.util.Optional;

@Service
public class KategorijaServiceImpl implements KategorijaService {

    private final KategorijaRepository kategorijaRepository;

    public KategorijaServiceImpl(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public Kategorija addKategorija(String kategorijaIme) {
        return kategorijaRepository.save(new Kategorija(kategorijaIme));
    }

    @Override
    public Optional<Kategorija> findById(Integer kategorijaId) {
        return kategorijaRepository.findById(kategorijaId);
    }

    @Override
    public List<Kategorija> findAll() {
        return kategorijaRepository.findAll();
    }
}
