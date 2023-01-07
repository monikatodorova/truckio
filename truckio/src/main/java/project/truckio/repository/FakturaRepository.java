package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Faktura;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {
}
