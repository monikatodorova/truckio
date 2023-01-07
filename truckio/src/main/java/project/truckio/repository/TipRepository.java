package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
}
