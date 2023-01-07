package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Klient;

import java.util.Optional;
@Repository
public interface KlientRepository extends JpaRepository<Klient, Integer> {

    Optional<Klient> findByEmail(String email);
    Optional<Klient> findByEmailAndPassword(String email, String password);
}
