package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer>{
}
