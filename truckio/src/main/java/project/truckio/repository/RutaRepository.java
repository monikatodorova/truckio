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

    //not functioning
    @Query(value = "select * from project.ruti r " +
            "       join project.rezervacii on r.ruta_id = rezervacii.ruta_id" +
            "       join project.vozaci on r.vozac_id = vozac.vozac_id" +
            "       where  " +
            "       lower(r.rezervacija_status) LIKE 'активна' and vozaci.vozac_id = :vozac_id ", nativeQuery = true)
    public List<Ruta> findActiveRoutesForVozac(Integer vozac_id);

}
