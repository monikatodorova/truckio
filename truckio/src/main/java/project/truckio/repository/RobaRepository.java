package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Roba;

import java.util.List;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Integer> {
    @Query(value = "select * from project.roba r where r.rezervacija_id = :rezervacija_id", nativeQuery = true)
    List<Roba> findRobaForReservation(Integer rezervacija_id);
}
