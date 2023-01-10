package project.truckio.service;

import project.truckio.model.Klient;
import project.truckio.model.Vraboten;

import java.util.List;
import java.util.Optional;

public interface VrabotenService {
    Vraboten registerVraboten(String vraboten_ime, String vraboten_prezime, String vraboten_email, String vraboten_password, Integer kompanija_id);
    Optional<Vraboten> findById(Integer vrabotenId);
    List<Vraboten> listAll();
    Vraboten login(String email, String password);
}
