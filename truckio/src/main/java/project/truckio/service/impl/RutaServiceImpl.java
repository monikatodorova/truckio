package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Dispecer;
import project.truckio.model.Grad;
import project.truckio.model.Ruta;
import project.truckio.model.Vozac;
import project.truckio.repository.DispecerRepository;
import project.truckio.repository.GradRepository;
import project.truckio.repository.RutaRepository;
import project.truckio.repository.VozacRepository;
import project.truckio.service.RutaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RutaServiceImpl implements RutaService {

    private final GradRepository gradRepository;
    private final DispecerRepository dispecerRepository;
    private final VozacRepository vozacRepository;
    private final RutaRepository rutaRepository;

    public RutaServiceImpl(GradRepository gradRepository, DispecerRepository dispecerRepository, VozacRepository vozacRepository, RutaRepository rutaRepository) {
        this.gradRepository = gradRepository;
        this.dispecerRepository = dispecerRepository;
        this.vozacRepository = vozacRepository;
        this.rutaRepository = rutaRepository;
    }

    @Override
    public Ruta addRuta(LocalDate datum_poagjanje, LocalDate datum_pristiganje, Integer zapocnuvaVoId, Integer zavrsuvaVoId, Integer dispecerId, Integer vozacId) {
        Grad zapocnuva_vo = gradRepository.findById(zapocnuvaVoId).get();
        Grad zavrsuva_vo = gradRepository.findById(zavrsuvaVoId).get();
        Dispecer dispecer = dispecerRepository.findById(dispecerId).get();
        Vozac vozac = vozacRepository.findById(vozacId).get();

        Ruta ruta = new Ruta(datum_poagjanje, datum_pristiganje, zapocnuva_vo, zavrsuva_vo, dispecer, vozac);
        return rutaRepository.save(ruta);
    }

    @Override
    public Optional<Ruta> findById(Integer rutaId) {
        return rutaRepository.findById(rutaId);
    }

    @Override
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }
}
