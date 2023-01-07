package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Administrator;
import project.truckio.model.Dispecer;
import project.truckio.model.Vraboten;
import project.truckio.repository.DispecerRepository;
import project.truckio.repository.VrabotenRepository;
import project.truckio.service.DispecerService;

import java.util.List;

@Service
public class DispecerServiceImpl implements DispecerService {

    private final DispecerRepository dispecerRepository;
    private final VrabotenRepository vrabotenRepository;

    public DispecerServiceImpl(DispecerRepository dispecerRepository, VrabotenRepository vrabotenRepository) {
        this.dispecerRepository = dispecerRepository;
        this.vrabotenRepository = vrabotenRepository;
    }

    @Override
    public Dispecer registerDispecer(Integer vrabotenId) {
        Vraboten vraboten = vrabotenRepository.findById(vrabotenId).get();
        return dispecerRepository.save(new Dispecer(vraboten));
    }

    @Override
    public Dispecer findById(Integer dispecerId) {
        return dispecerRepository.findById(dispecerId).get();
    }

    @Override
    public List<Dispecer> findAll() {
        return dispecerRepository.findAll();
    }
}
