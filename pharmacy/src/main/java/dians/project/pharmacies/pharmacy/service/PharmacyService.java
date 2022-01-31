package dians.project.pharmacies.pharmacy.service;

import dians.project.pharmacies.pharmacy.VO.ResponseTemplateVO;
import dians.project.pharmacies.pharmacy.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> findByName(String name);
    ResponseTemplateVO findByMunicipalityId(Long id);
}
