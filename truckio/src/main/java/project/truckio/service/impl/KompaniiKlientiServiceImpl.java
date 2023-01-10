package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.KompaniiKlienti;
import project.truckio.model.Kompanija;
import project.truckio.repository.KompaniiKlientiRepository;
import project.truckio.service.KompaniiKlientiService;
import project.truckio.service.KompanijaService;

import java.util.List;

@Service
public class KompaniiKlientiServiceImpl implements KompaniiKlientiService {

    private final KompaniiKlientiRepository kompaniiKlientiRepository;
    private final KompanijaService kompanijaService;

    public KompaniiKlientiServiceImpl(KompaniiKlientiRepository kompaniiKlientiRepository, KompanijaService kompanijaService) {
        this.kompaniiKlientiRepository = kompaniiKlientiRepository;
        this.kompanijaService = kompanijaService;
    }

    @Override
    public List<KompaniiKlienti> listAll() {
        return kompaniiKlientiRepository.findAll();
    }

    @Override
    public List<KompaniiKlienti> findByCompanyId(Integer kompanija_id) {
        Kompanija kompanija = kompanijaService.findById(kompanija_id);
        return kompaniiKlientiRepository.findAllByKompanija(kompanija);
    }
}
