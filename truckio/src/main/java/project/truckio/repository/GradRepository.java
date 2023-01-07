package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Grad;

@Repository
public interface GradRepository extends JpaRepository<Grad, Integer> {
}
