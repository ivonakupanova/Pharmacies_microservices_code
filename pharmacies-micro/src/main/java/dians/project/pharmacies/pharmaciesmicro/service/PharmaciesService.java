package dians.project.pharmacies.pharmaciesmicro.service;


import dians.project.pharmacies.pharmaciesmicro.VO.Municipality;
import dians.project.pharmacies.pharmaciesmicro.VO.ResponseTemplateVO;

import java.util.List;

public interface PharmaciesService {
    ResponseTemplateVO findAllMunicipalities();
    ResponseTemplateVO findByName(String name);
    ResponseTemplateVO findByMunicipality(Long id);
    ResponseTemplateVO findByMunicipalityApi(Long id);
    ResponseTemplateVO findByNameApi(String name);

}
