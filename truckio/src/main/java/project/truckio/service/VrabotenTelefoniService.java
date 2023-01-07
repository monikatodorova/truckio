package project.truckio.service;

import project.truckio.model.VrabotenTelefoni;

import java.util.List;

public interface VrabotenTelefoniService {
    VrabotenTelefoni addVrabotenTelefon(Integer vrabotenId, String telefon);
    List<VrabotenTelefoni> findAll();
    List<VrabotenTelefoni> findAllByVraboten(Integer vrabotenId);
}
