package project.truckio.service;

import project.truckio.model.Tip;

import java.util.List;

public interface TipService {
    Tip addTip(String tipIme);
    Tip findById(Integer tipId);
    List<Tip> findAll();
}
