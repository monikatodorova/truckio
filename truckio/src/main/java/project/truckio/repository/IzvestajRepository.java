package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Izvestaj;
import project.truckio.model.Vozilo;

import java.util.List;

@Repository
public interface IzvestajRepository extends JpaRepository<Izvestaj, Integer> {
}
