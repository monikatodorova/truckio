package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Licenca;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Integer> {
}
