package project.truckio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.truckio.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
}
