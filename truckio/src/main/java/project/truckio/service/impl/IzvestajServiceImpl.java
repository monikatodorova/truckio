package project.truckio.service.impl;

import org.springframework.stereotype.Service;
import project.truckio.model.Izvestaj;
import project.truckio.repository.IzvestajRepository;
import project.truckio.service.IzvestajService;

import java.util.List;
@Service
public class IzvestajServiceImpl implements IzvestajService {

    private final IzvestajRepository izvestajRepository;

    public IzvestajServiceImpl(IzvestajRepository izvestajRepository) {
        this.izvestajRepository = izvestajRepository;
    }

    @Override
    public List<Izvestaj> listAll() {
        return izvestajRepository.findAll();
    }

    @Override
    public Izvestaj findById(Integer kompanija_id) {
        return izvestajRepository.findById(kompanija_id).get();
    }
}
