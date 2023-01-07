package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Tip;
import project.truckio.repository.TipRepository;
import project.truckio.service.TipService;

import java.util.List;

@Service
public class TipServiceImpl implements TipService {

    private final TipRepository tipRepository;

    public TipServiceImpl(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @Override
    public Tip addTip(String tipIme) {
        return tipRepository.save(new Tip(tipIme));
    }

    @Override
    public Tip findById(Integer tipId) {
        return tipRepository.findById(tipId).get();
    }

    @Override
    public List<Tip> findAll() {
        return tipRepository.findAll();
    }
}
