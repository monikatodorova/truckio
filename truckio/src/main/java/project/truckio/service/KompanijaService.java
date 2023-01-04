package project.truckio.service;

import project.truckio.model.Kompanija;

import java.util.List;

public interface KompanijaService {
    List<Kompanija> listAll();
    Kompanija findById(Integer kompanija_id);
}
