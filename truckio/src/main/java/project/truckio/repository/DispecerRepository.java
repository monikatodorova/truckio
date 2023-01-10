package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.truckio.model.Dispecer;

import java.util.List;

@Repository
public interface DispecerRepository extends JpaRepository<Dispecer, Integer> {

    @Query(value = "select * from project.dispeceri d join project.vraboteni v on d.dispecer_id=v.vraboten_id " +
            "where v.kompanija_id = :kompanija_id", nativeQuery = true)
    public List<Dispecer> findAllByCompany(Integer kompanija_id);

}
