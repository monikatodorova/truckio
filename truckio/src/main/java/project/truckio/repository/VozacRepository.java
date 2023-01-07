package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Vozac;

@Repository
public interface VozacRepository extends JpaRepository<Vozac, Integer> {
}
