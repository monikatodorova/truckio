package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Vraboten;

@Repository
public interface VrabotenRepository extends JpaRepository<Vraboten, Integer>{
}
