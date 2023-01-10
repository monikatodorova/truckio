package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Rezervacija;
import project.truckio.model.Ruta;

import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer>{
    @Query(value = "select * from project.rezervacii r where r.klient_id = :klient_id", nativeQuery = true)
    public List<Rezervacija> findMyReservations(Integer klient_id);

}
