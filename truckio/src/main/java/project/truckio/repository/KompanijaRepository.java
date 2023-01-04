package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Kompanija;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Integer> {
}
