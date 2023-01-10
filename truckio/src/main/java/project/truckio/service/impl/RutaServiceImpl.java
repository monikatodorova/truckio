package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.*;
import project.truckio.repository.*;
import project.truckio.service.RutaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RutaServiceImpl implements RutaService {

    private final GradRepository gradRepository;
    private final DispecerRepository dispecerRepository;
    private final VozacRepository vozacRepository;
    private final RutaRepository rutaRepository;
    private final VoziloRepository voziloRepository;

    public RutaServiceImpl(GradRepository gradRepository, DispecerRepository dispecerRepository, VozacRepository vozacRepository, RutaRepository rutaRepository, VoziloRepository voziloRepository) {
        this.gradRepository = gradRepository;
        this.dispecerRepository = dispecerRepository;
        this.vozacRepository = vozacRepository;
        this.rutaRepository = rutaRepository;
        this.voziloRepository = voziloRepository;
    }

    @Override
    public Ruta addRuta(LocalDate datum_poagjanje, LocalDate datum_pristiganje, Integer zapocnuvaVoId, Integer zavrsuvaVoId, Integer voziloId, Integer dispecerId, Integer vozacId) {
        Grad zapocnuva_vo = gradRepository.findById(zapocnuvaVoId).get();
        Grad zavrsuva_vo = gradRepository.findById(zavrsuvaVoId).get();
        Vozilo vozilo = voziloRepository.findById(voziloId).get();
        Dispecer dispecer = dispecerRepository.findById(dispecerId).get();
        Vozac vozac = vozacRepository.findById(vozacId).get();

        Ruta ruta = new Ruta(datum_poagjanje, datum_pristiganje, zapocnuva_vo, zavrsuva_vo, vozilo, dispecer, vozac);
        return rutaRepository.save(ruta);
    }

    @Override
    public Ruta findById(Integer rutaId) {
        return rutaRepository.findById(rutaId).get();
    }

    @Override
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    @Override
    public List<Ruta> findAllByCompany(Integer kompanijaId) {
        return rutaRepository.findAllByCompany(kompanijaId);
    }

    @Override
    public List<Ruta> findAllAvailable() {
        return rutaRepository.findAllAvailable();
    }
}
