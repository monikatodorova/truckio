package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.passwordencrypt.CryptWithMD5;
import project.truckio.model.Klient;
import project.truckio.model.exceptions.*;
import project.truckio.repository.KlientRepository;
import project.truckio.service.KlientService;

@Service
public class KlientServiceImpl implements KlientService {

    private final KlientRepository klientRepository;
    //private final PasswordEncoder passwordEncoder;

    public KlientServiceImpl(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Klient register(String ime, String prezime, String password, String repeatPassword, String email, String telefon) {
        if(email == null || email.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }

        if(!password.equals(repeatPassword)) throw new PasswordsDoNotMatch();

        if(klientRepository.findByEmail(email).isPresent()) {
            throw new UsernameAlreadyExistsException(email);
        }

        Klient klient = new Klient(ime, prezime, email, CryptWithMD5.cryptWithMD5(password), telefon);
        return klientRepository.save(klient);

    }

    @Override
    public Klient login(String email, String password) {
        if(email == null || email.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        return klientRepository.findByEmailAndPassword(email, CryptWithMD5.cryptWithMD5(password)).orElseThrow(InvalidUserCredentialsException::new);
    }

}
