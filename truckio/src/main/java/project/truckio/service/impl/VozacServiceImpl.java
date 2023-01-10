package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Administrator;
import project.truckio.model.Vozac;
import project.truckio.model.Vraboten;
import project.truckio.repository.AdministratorRepository;
import project.truckio.repository.VozacRepository;
import project.truckio.repository.VrabotenRepository;
import project.truckio.service.VozacService;

import java.util.List;
import java.util.Optional;

@Service
public class VozacServiceImpl implements VozacService {

    private final VozacRepository vozacRepository;
    private final VrabotenRepository vrabotenRepository;

    public VozacServiceImpl(VozacRepository vozacRepository, VrabotenRepository vrabotenRepository) {
        this.vozacRepository = vozacRepository;
        this.vrabotenRepository = vrabotenRepository;
    }

    @Override
    public Vozac registerVozac(Integer vrabotenId) {
        Vraboten vraboten = vrabotenRepository.findById(vrabotenId).get();
        return vozacRepository.save(new Vozac(vraboten));
    }

    @Override
    public Vozac findById(Integer vozacId) {
        return vozacRepository.findById(vozacId).get();
    }

    @Override
    public List<Vozac> findAll() {
        return vozacRepository.findAll();
    }

    @Override
    public Optional<Vozac> findRole(Integer vozacId) {
        return vozacRepository.findById(vozacId);
    }
}
