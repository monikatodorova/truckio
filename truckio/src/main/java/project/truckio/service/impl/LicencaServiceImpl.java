package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Licenca;
import project.truckio.repository.LicencaRepository;
import project.truckio.service.LicencaService;

import java.util.List;
import java.util.Optional;

@Service
public class LicencaServiceImpl implements LicencaService {

    private final LicencaRepository licencaRepository;

    public LicencaServiceImpl(LicencaRepository licencaRepository) {
        this.licencaRepository = licencaRepository;
    }

    @Override
    public Optional<Licenca> findById(Integer licencaId) {
        return licencaRepository.findById(licencaId);
    }

    @Override
    public List<Licenca> findAll() {
        return licencaRepository.findAll();
    }
}
