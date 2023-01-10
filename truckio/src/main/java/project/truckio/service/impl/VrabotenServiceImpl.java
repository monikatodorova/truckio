package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Klient;
import project.truckio.model.Kompanija;
import project.truckio.model.Vraboten;
import project.truckio.model.exceptions.InvalidArgumentException;
import project.truckio.model.exceptions.InvalidUserCredentialsException;
import project.truckio.model.exceptions.InvalidUsernameOrPasswordException;
import project.truckio.model.passwordencrypt.CryptWithMD5;
import project.truckio.repository.KompanijaRepository;
import project.truckio.repository.VrabotenRepository;
import project.truckio.service.VrabotenService;

import java.util.List;
import java.util.Optional;

@Service
public class VrabotenServiceImpl implements VrabotenService {

    private final VrabotenRepository vrabotenRepository;
    private final KompanijaRepository kompanijaRepository;

    public VrabotenServiceImpl(VrabotenRepository vrabotenRepository, KompanijaRepository kompanijaRepository) {
        this.vrabotenRepository = vrabotenRepository;
        this.kompanijaRepository = kompanijaRepository;
    }

    @Override
    public Vraboten registerVraboten(String vraboten_ime, String vraboten_prezime, String vraboten_email, String vraboten_password, Integer kompanija_id) {
        Kompanija vraboten_kompanija = kompanijaRepository.findById(kompanija_id).get();
        Vraboten vraboten = new Vraboten(vraboten_ime, vraboten_prezime, vraboten_email, vraboten_password, vraboten_kompanija);
        return vrabotenRepository.save(vraboten);
    }

    @Override
    public Optional<Vraboten> findById(Integer vrabotenId) {
        return vrabotenRepository.findById(vrabotenId);
    }

    @Override
    public List<Vraboten> listAll() {
        return vrabotenRepository.findAll();
    }

    @Override
    public Vraboten login(String email, String password) {
        if(email == null || email.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        return vrabotenRepository.findByEmailAndPassword(email, CryptWithMD5.cryptWithMD5(password)).orElseThrow(InvalidUsernameOrPasswordException::new);
    }
}
