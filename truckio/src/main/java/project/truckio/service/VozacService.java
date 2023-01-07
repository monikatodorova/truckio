package project.truckio.service;

import project.truckio.model.Administrator;
import project.truckio.model.Vozac;

import java.util.List;

public interface VozacService {
    Vozac registerVozac(Integer vrabotenId);
    Vozac findById(Integer vozacId);
    List<Vozac> findAll();
}
