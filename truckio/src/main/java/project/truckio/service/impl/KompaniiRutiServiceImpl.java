package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.KompaniiRuti;
import project.truckio.model.Kompanija;
import project.truckio.repository.KompaniiRutiRepository;
import project.truckio.service.KompaniiRutiService;
import project.truckio.service.KompanijaService;

import java.util.List;
@Service
public class KompaniiRutiServiceImpl implements KompaniiRutiService {

    private final KompaniiRutiRepository kompaniiRutiRepository;
    private final KompanijaService kompanijaService;

    public KompaniiRutiServiceImpl(KompaniiRutiRepository kompaniiRutiRepository, KompanijaService kompanijaService) {
        this.kompaniiRutiRepository = kompaniiRutiRepository;
        this.kompanijaService = kompanijaService;
    }

    @Override
    public List<KompaniiRuti> listAll() {
        return kompaniiRutiRepository.findAll();
    }

    @Override
    public List<KompaniiRuti> findByCompanyId(Integer kompanija_id) {
        Kompanija kompanija = kompanijaService.findById(kompanija_id);
        return kompaniiRutiRepository.findAllByKompanija(kompanija);
    }
}
