package project.truckio.service;

import project.truckio.model.Licenca;

import java.util.List;
import java.util.Optional;

public interface LicencaService {
    //Licenca addLicenca();
    Optional<Licenca> findById(Integer licencaId);
    List<Licenca> findAll();
}
