package dians.project.pharmacies.pharmaciesmicro.service;

import dians.project.pharmacies.pharmaciesmicro.VO.Municipality;
import dians.project.pharmacies.pharmaciesmicro.VO.Pharmacy;
import dians.project.pharmacies.pharmaciesmicro.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PharmaciesServiceImpl implements PharmaciesService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseTemplateVO findAllMunicipalities() {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        ResponseEntity<Municipality[]> municipalitiesEntity =
                restTemplate.getForEntity(
                        "http://localhost:9091/pharmacies/getAllMunicipalities",
                        Municipality[].class);

        Municipality[] municipalities = municipalitiesEntity.getBody();

        vo.setMunicipalities(municipalities);
        return vo;
    }

    @Override
    public ResponseTemplateVO findByName(String pharmacyName) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        ResponseEntity<Pharmacy[]> pharmaciesEntity =
                restTemplate.getForEntity(
                        "http://localhost:9092/pharmacies/findPharmacies?namePharmacy=" + pharmacyName,
                        Pharmacy[].class);

        Pharmacy[] pharmacies = pharmaciesEntity.getBody();

        vo.setPharmacies(pharmacies);
        return vo;
    }

    @Override
    public ResponseTemplateVO findByMunicipality(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        ResponseEntity<Pharmacy[]> pharmaciesEntity =
                restTemplate.getForEntity(
                        "http://localhost:9092/pharmacies/findPharmacies?idMunicipality=" + id,
                        Pharmacy[].class);

        Pharmacy[] pharmacies = pharmaciesEntity.getBody();

        vo.setPharmacies(pharmacies);
        return vo;
    }

    @Override
    public ResponseTemplateVO findByMunicipalityApi(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        ResponseEntity<Pharmacy[]> pharmaciesEntity =
                restTemplate.getForEntity(
                        "http://localhost:9092/pharmacies/api/findByMunicipality?idMunicipality=" + id,
                        Pharmacy[].class);

        Pharmacy[] pharmacies = pharmaciesEntity.getBody();

        vo.setPharmacies(pharmacies);
        return vo;
    }

    @Override
    public ResponseTemplateVO findByNameApi(String pharmacyName) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        ResponseEntity<Pharmacy[]> pharmaciesEntity =
                restTemplate.getForEntity(
                        "http://localhost:9092/pharmacies/api/findByName?namePharmacy=" + pharmacyName,
                        Pharmacy[].class);

        Pharmacy[] pharmacies = pharmaciesEntity.getBody();

        vo.setPharmacies(pharmacies);
        return vo;
    }

}
