package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Vraboten;
import project.truckio.model.VrabotenTelefoni;
import project.truckio.model.primarykeys.VrabotenTelefoniID;
import project.truckio.repository.VrabotenRepository;
import project.truckio.repository.VrabotenTelefoniRepository;
import project.truckio.service.VrabotenTelefoniService;

import java.util.List;

@Service
public class VrabotenTelefoniImpl implements VrabotenTelefoniService {

    private final VrabotenRepository vrabotenRepository;
    private final VrabotenTelefoniRepository vrabotenTelefoniRepository;

    public VrabotenTelefoniImpl(VrabotenRepository vrabotenRepository, VrabotenTelefoniRepository vrabotenTelefoniRepository) {
        this.vrabotenRepository = vrabotenRepository;
        this.vrabotenTelefoniRepository = vrabotenTelefoniRepository;
    }

    @Override
    public VrabotenTelefoni addVrabotenTelefon(Integer vrabotenId, String telefon) {
        Vraboten vraboten = vrabotenRepository.findById(vrabotenId).get();
        VrabotenTelefoniID vrabotenTelefoniID = new VrabotenTelefoniID(vrabotenId, telefon);

        VrabotenTelefoni vrabotenTelefoni = new VrabotenTelefoni(vrabotenTelefoniID, vraboten);
        return vrabotenTelefoniRepository.save(vrabotenTelefoni);
    }

    @Override
    public List<VrabotenTelefoni> findAll() {
        return vrabotenTelefoniRepository.findAll();
    }

    @Override
    public List<VrabotenTelefoni> findAllByVraboten(Integer vrabotenId) {
        Vraboten vraboten = vrabotenRepository.findById(vrabotenId).get();
        return vrabotenTelefoniRepository.findAllByVraboten(vraboten);
    }
}
