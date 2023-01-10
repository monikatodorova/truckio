package project.truckio.service;

import project.truckio.model.Dispecer;

import java.util.List;
import java.util.Optional;

public interface DispecerService {
    Dispecer registerDispecer(Integer vrabotenId);
    Dispecer findById(Integer dispecerId);
    List<Dispecer> findAll();
    Optional<Dispecer> findRole(Integer dispecerId);
    List<Dispecer> findAllByCompany(Integer kompanijaId);
}
