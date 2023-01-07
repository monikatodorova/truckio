package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Roba;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Integer> {
}
