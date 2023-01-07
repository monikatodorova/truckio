package project.truckio.service;

import project.truckio.model.Grad;

import java.util.List;
import java.util.Optional;

public interface GradService {
    Grad registerGrad(String gradIme);
    Optional<Grad> findById(Integer gradId);
    List<Grad> findAll();
}
