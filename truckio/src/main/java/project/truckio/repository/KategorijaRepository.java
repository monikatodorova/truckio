package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
}
