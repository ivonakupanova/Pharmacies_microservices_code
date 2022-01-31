package dians.project.pharmacies.pharmacy.service;

import dians.project.pharmacies.pharmacy.VO.Municipality;
import dians.project.pharmacies.pharmacy.VO.ResponseTemplateVO;
import dians.project.pharmacies.pharmacy.model.Pharmacy;
import dians.project.pharmacies.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository)
    {
        this.pharmacyRepository=pharmacyRepository;
    }

    @Override
    public List<Pharmacy> findByName(String name) {
        return pharmacyRepository.findAllByName(name);
    }

    @Override
    public ResponseTemplateVO findByMunicipalityId(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<Pharmacy> pharmacies = this.pharmacyRepository.findAllByMunicipalityId(id);

        Municipality municipality =
                restTemplate.getForObject("http://localhost:9091/pharmacies/" +
                        "getMunicipality/" + id,
                Municipality.class);

        vo.setMunicipality(municipality);
        vo.setPharmacies(pharmacies);
        return vo;
    }
}
