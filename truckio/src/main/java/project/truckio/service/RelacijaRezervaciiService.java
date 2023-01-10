package project.truckio.service;

import project.truckio.model.KompaniiKlienti;
import project.truckio.model.RelacijaRezervacii;

import java.util.List;

public interface RelacijaRezervaciiService {
    List<RelacijaRezervacii> listAll();
    List<RelacijaRezervacii> findByCompanyId(Integer kompanija_id);
}
