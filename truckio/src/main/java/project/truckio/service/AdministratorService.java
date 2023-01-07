package project.truckio.service;

import project.truckio.model.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator registerAdministrator(Integer vrabotenId);
    Administrator findById(Integer administratorId);
    List<Administrator> findAll();
}
