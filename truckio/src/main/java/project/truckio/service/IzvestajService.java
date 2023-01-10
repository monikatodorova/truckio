package project.truckio.service;

import org.springframework.stereotype.Service;
import project.truckio.model.Izvestaj;
import project.truckio.model.Kompanija;

import java.util.List;

public interface IzvestajService {
    List<Izvestaj> listAll();
    Izvestaj findById(Integer kompanija_id);
}
