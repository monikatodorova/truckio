package project.truckio.service;

import project.truckio.model.Izvestaj;
import project.truckio.model.KompaniiKlienti;

import java.util.List;

public interface KompaniiKlientiService {
    List<KompaniiKlienti> listAll();
    List<KompaniiKlienti> findByCompanyId(Integer kompanija_id);
}
