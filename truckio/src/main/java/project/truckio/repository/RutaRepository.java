package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Ruta;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer>{
    @Query(value = "select * from project.ruti r where r.datum_poagjanje > now()", nativeQuery = true)
    public List<Ruta> findAllAvailable();
}
