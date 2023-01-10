package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Ruta;
import project.truckio.model.Vozac;

import java.util.List;

@Repository
public interface VozacRepository extends JpaRepository<Vozac, Integer> {

}
