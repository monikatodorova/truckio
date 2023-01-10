package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.KompaniiKlienti;
import project.truckio.model.Kompanija;

import java.util.List;

@Repository
public interface KompaniiKlientiRepository extends JpaRepository<KompaniiKlienti, Integer> {
    public List<KompaniiKlienti> findAllByKompanija(Kompanija kompanija);
}
