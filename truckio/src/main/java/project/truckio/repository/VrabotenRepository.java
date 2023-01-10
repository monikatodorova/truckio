package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Klient;
import project.truckio.model.Vraboten;

import java.util.Optional;

@Repository
public interface VrabotenRepository extends JpaRepository<Vraboten, Integer>{
    Optional<Vraboten> findByEmailAndPassword(String email, String password);
}
