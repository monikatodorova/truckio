package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Dispecer;

@Repository
public interface DispecerRepository extends JpaRepository<Dispecer, Integer> {
}
