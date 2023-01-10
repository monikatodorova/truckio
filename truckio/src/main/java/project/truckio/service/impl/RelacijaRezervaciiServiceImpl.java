package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Kompanija;
import project.truckio.model.RelacijaRezervacii;
import project.truckio.repository.RelacijaRezervaciiRepository;
import project.truckio.service.KompanijaService;
import project.truckio.service.RelacijaRezervaciiService;

import java.util.List;

@Service
public class RelacijaRezervaciiServiceImpl implements RelacijaRezervaciiService {

    private final RelacijaRezervaciiRepository relacijaRezervaciiRepository;
    private final KompanijaService kompanijaService;

    public RelacijaRezervaciiServiceImpl(RelacijaRezervaciiRepository relacijaRezervaciiRepository, KompanijaService kompanijaService) {
        this.relacijaRezervaciiRepository = relacijaRezervaciiRepository;
        this.kompanijaService = kompanijaService;
    }

    @Override
    public List<RelacijaRezervacii> listAll() {
        return relacijaRezervaciiRepository.findAll();
    }

    @Override
    public List<RelacijaRezervacii> findByCompanyId(Integer kompanija_id) {
        Kompanija kompanija = kompanijaService.findById(kompanija_id);
        return relacijaRezervaciiRepository.findAllByKompanija(kompanija);
    }
}
