package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Vozilo;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, Integer> {
}
