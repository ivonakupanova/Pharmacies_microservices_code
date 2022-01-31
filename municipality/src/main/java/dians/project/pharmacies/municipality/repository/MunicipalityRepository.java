package dians.project.pharmacies.municipality.repository;

import dians.project.pharmacies.municipality.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    Municipality findMunicipalityByName(String name);
    Municipality findMunicipalityById(Long id);
}
