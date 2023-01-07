package project.truckio.service;

import project.truckio.model.Dispecer;

import java.util.List;

public interface DispecerService {
    Dispecer registerDispecer(Integer vrabotenId);
    Dispecer findById(Integer dispecerId);
    List<Dispecer> findAll();
}
