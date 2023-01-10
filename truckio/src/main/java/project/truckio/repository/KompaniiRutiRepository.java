package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.KompaniiRuti;
import project.truckio.model.Kompanija;

import java.util.List;
@Repository
public interface KompaniiRutiRepository extends JpaRepository<KompaniiRuti, Integer> {
    public List<KompaniiRuti> findAllByKompanija(Kompanija kompanija);
}
