package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Ruta;
import project.truckio.model.Vozilo;

import java.util.List;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, Integer> {
    @Query(value = "select * from project.vozila v " +
            "where v.kompanija_id = :kompanija_id", nativeQuery = true)
    public List<Vozilo> findAllByCompany(Integer kompanija_id);
}
