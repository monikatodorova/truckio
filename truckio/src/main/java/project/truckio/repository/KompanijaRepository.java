package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Kompanija;

import java.util.Optional;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Integer> {
}
