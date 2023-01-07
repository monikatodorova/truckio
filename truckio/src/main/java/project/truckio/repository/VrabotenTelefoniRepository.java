package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Vraboten;
import project.truckio.model.VrabotenTelefoni;

import java.util.List;

@Repository
public interface VrabotenTelefoniRepository extends JpaRepository<VrabotenTelefoni, Integer> {
    List<VrabotenTelefoni> findAllByVraboten(Vraboten vraboten);
}
