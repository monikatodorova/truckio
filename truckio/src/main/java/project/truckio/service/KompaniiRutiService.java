package project.truckio.service;

import project.truckio.model.KompaniiKlienti;
import project.truckio.model.KompaniiRuti;

import java.util.List;

public interface KompaniiRutiService {
    List<KompaniiRuti> listAll();
    List<KompaniiRuti> findByCompanyId(Integer kompanija_id);
}
