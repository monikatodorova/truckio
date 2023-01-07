package project.truckio.service;

import project.truckio.model.Klient;

import java.util.List;
import java.util.Optional;

public interface KlientService {
    Klient register(String ime, String prezime, String password, String repeatPassword, String email, String telefon);
    Klient login(String email, String password);
    Optional<Klient> findById(Integer klientId);
    List<Klient> findAll();
}
