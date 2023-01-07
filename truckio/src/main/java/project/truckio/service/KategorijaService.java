package project.truckio.service;

import project.truckio.model.Kategorija;

import java.util.List;
import java.util.Optional;

public interface KategorijaService {
    Kategorija addKategorija(String kategorijaIme);
    Optional<Kategorija> findById(Integer kategorijaId);
    List<Kategorija> findAll();
}
