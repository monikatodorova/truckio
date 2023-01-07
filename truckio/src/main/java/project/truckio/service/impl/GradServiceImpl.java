package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Grad;
import project.truckio.repository.GradRepository;
import project.truckio.service.GradService;

import java.util.List;
import java.util.Optional;

@Service
public class GradServiceImpl implements GradService {

    private final GradRepository gradRepository;

    public GradServiceImpl(GradRepository gradRepository) {
        this.gradRepository = gradRepository;
    }

    @Override
    public Grad registerGrad(String gradIme) {
        return gradRepository.save(new Grad(gradIme));
    }

    @Override
    public Optional<Grad> findById(Integer gradId) {
        return gradRepository.findById(gradId);
    }

    @Override
    public List<Grad> findAll() {
        return gradRepository.findAll();
    }
}
