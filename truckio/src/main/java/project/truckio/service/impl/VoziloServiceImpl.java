package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Kompanija;
import project.truckio.model.Tip;
import project.truckio.model.Vozac;
import project.truckio.model.Vozilo;
import project.truckio.repository.KompanijaRepository;
import project.truckio.repository.TipRepository;
import project.truckio.repository.VozacRepository;
import project.truckio.repository.VoziloRepository;
import project.truckio.service.VoziloService;

import java.util.List;
import java.util.Optional;

@Service
public class VoziloServiceImpl implements VoziloService {

    private final VoziloRepository voziloRepository;
    private final KompanijaRepository kompanijaRepository;
    private final TipRepository tipRepository;
    private final VozacRepository vozacRepository;

    public VoziloServiceImpl(VoziloRepository voziloRepository, KompanijaRepository kompanijaRepository, TipRepository tipRepository, VozacRepository vozacRepository) {
        this.voziloRepository = voziloRepository;
        this.kompanijaRepository = kompanijaRepository;
        this.tipRepository = tipRepository;
        this.vozacRepository = vozacRepository;
    }

    @Override
    public Vozilo registerVozilo(String vozilo_marka, Integer vozilo_kapacitet, Integer kompanijaId, Integer tipId, Integer vozacId) {
        Kompanija kompanija = kompanijaRepository.findById(kompanijaId).get();
        Tip tip = tipRepository.findById(tipId).get();
        Vozac vozac = vozacRepository.findById(vozacId).get();
        Vozilo vozilo = new Vozilo(vozilo_marka, vozilo_kapacitet, kompanija, tip, vozac);
        return voziloRepository.save(vozilo);
    }

    @Override
    public Optional<Vozilo> findById(Integer voziloId) {
        return voziloRepository.findById(voziloId);
    }

    @Override
    public List<Vozilo> findAll() {
        return voziloRepository.findAll();
    }

    @Override
    public List<Vozilo> findAllByCompany(Integer kompanijaId) {
        return voziloRepository.findAllByCompany(kompanijaId);
    }
}
