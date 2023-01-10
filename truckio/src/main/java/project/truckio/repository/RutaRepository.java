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

    @Query(value = "select * from project.ruti r join project.vozila v on r.vozilo_id=v.vozilo_id " +
            "where v.kompanija_id = :kompanija_id", nativeQuery = true)
    public List<Ruta> findAllByCompany(Integer kompanija_id);

    @Query(value = "select * from project.ruti r " +
            "       join project.rezervacii rezervacija on r.ruta_id = rezervacija.ruta_id" +
            "       join project.vozaci vozac on r.vozac_id = vozac.vozac_id" +
            "       where  " +
            "       lower(rezervacija.rezervacija_status) LIKE 'активна' and vozac.vozac_id = :vozac_id ", nativeQuery = true)
    public List<Ruta> findAllActiveByVozac(Integer vozac_id);

    @Query(value = "select * from project.ruti r " +
            "       join project.rezervacii rezervacija on r.ruta_id = rezervacija.ruta_id" +
            "       join project.dispeceri dispecer on r.dispecer_id = dispecer.dispecer_id" +
            "       where  " +
            "       lower(rezervacija.rezervacija_status) LIKE 'активна' and dispecer.dispecer_id = :dispecer_id ", nativeQuery = true)
    public List<Ruta> findAllActiveByDispecer(Integer dispecer_id);
}
