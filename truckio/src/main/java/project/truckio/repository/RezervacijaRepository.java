package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Rezervacija;

import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer>{
    @Query(value = "select * from project.rezervacii r where r.klient_id = :klient_id", nativeQuery = true)
    public List<Rezervacija> findMyReservations(Integer klient_id);
    @Query(value = "select * from project.rezervacii r where r.ruta_id = :ruta_id " +
            "and (lower(r.rezervacija_status) LIKE 'активна' " +
            "or lower(r.rezervacija_status) LIKE 'за одобрување')", nativeQuery = true)
    List<Rezervacija> findReservationsForRoute(Integer ruta_id);

    @Query(value = "select * from project.rezervacii r " +
            "join project.ruti ruti on r.ruta_id = ruti.ruta_id " +
            "join project.vozila v on ruti.vozilo_id = v.vozilo_id " +
            "where lower(r.rezervacija_status) LIKE 'за одобрување' and v.kompanija_id = :kompanija_id", nativeQuery = true)
    List<Rezervacija> findAllReservationsByCompany(Integer kompanija_id);
}
