package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Administrator;
import project.truckio.model.Vraboten;
import project.truckio.repository.AdministratorRepository;
import project.truckio.repository.VrabotenRepository;
import project.truckio.service.AdministratorService;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    private final VrabotenRepository vrabotenRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository, VrabotenRepository vrabotenRepository) {
        this.administratorRepository = administratorRepository;
        this.vrabotenRepository = vrabotenRepository;
    }

    @Override
    public Administrator registerAdministrator(Integer vrabotenId) {
        Vraboten vraboten = vrabotenRepository.findById(vrabotenId).get();
        return administratorRepository.save(new Administrator(vraboten));
    }

    @Override
    public Administrator findById(Integer administratorId) {
        return administratorRepository.findById(administratorId).get();
    }

    @Override
    public List<Administrator> findAll() {
        return administratorRepository.findAll();
    }
}
