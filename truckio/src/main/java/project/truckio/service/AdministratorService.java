package project.truckio.service;

import project.truckio.model.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdministratorService {
    Administrator registerAdministrator(Integer vrabotenId);
    Administrator findById(Integer administratorId);
    List<Administrator> findAll();

    Optional<Administrator> findRole(Integer administratorId);
}
