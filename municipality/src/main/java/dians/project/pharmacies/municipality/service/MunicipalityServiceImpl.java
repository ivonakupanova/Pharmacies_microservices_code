package dians.project.pharmacies.municipality.service;


import dians.project.pharmacies.municipality.model.Municipality;
import dians.project.pharmacies.municipality.repository.MunicipalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {
    public MunicipalityRepository municipalitiesRepository;

    public MunicipalityServiceImpl(MunicipalityRepository municipalitiesRepository) {
        this.municipalitiesRepository=municipalitiesRepository;
    }

    @Override
    public List<Municipality> findAll() {
        return municipalitiesRepository.findAll();
    }

    @Override
    public Municipality findByName(String name) {

        return municipalitiesRepository.findMunicipalityByName(name);
    }

    @Override
    public Municipality findById(Long id) {
        return this.municipalitiesRepository.findMunicipalityById(id);
    }

}
