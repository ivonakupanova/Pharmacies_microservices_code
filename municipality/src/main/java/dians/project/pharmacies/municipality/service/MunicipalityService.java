package dians.project.pharmacies.municipality.service;

import dians.project.pharmacies.municipality.model.Municipality;

import java.util.List;

public interface MunicipalityService {
    List<Municipality> findAll();
    Municipality findByName(String name);
    Municipality findById(Long id);
}
