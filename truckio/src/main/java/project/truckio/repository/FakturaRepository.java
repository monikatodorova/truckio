package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Faktura;
import project.truckio.model.Rezervacija;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {
    public Faktura findFakturaByRezervacija(Rezervacija rezervacija);
}
