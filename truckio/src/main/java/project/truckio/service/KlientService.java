package project.truckio.service;

import project.truckio.model.Klient;

public interface KlientService {
    Klient register(String ime, String prezime, String password, String repeatPassword, String email, String telefon);

    Klient login(String email, String password);
}
