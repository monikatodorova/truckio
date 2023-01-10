package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.KompaniiKlienti;
import project.truckio.model.Kompanija;
import project.truckio.model.RelacijaRezervacii;

import java.util.List;

@Repository
public interface RelacijaRezervaciiRepository extends JpaRepository<RelacijaRezervacii, Integer> {
    public List<RelacijaRezervacii> findAllByKompanija(Kompanija kompanija);
}
