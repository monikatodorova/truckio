package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Kompanija;
import project.truckio.repository.KompanijaRepository;
import project.truckio.service.KompanijaService;

import java.util.List;

@Service
public class KompanijaServiceImpl implements KompanijaService {
    private final KompanijaRepository kompanijaRepository;

    public KompanijaServiceImpl(KompanijaRepository kompanijaRepository) {
        this.kompanijaRepository = kompanijaRepository;
    }

    @Override
    public List<Kompanija> listAll() {
        return this.kompanijaRepository.findAll();
    }

    @Override
    public Kompanija findById(Integer kompanija_id) {
        return this.kompanijaRepository.findById(kompanija_id).get();
    }


}
