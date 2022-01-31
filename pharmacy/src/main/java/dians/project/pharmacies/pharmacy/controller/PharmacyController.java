package dians.project.pharmacies.pharmacy.controller;

import dians.project.pharmacies.pharmacy.model.Pharmacy;
import dians.project.pharmacies.pharmacy.service.PharmacyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    public final PharmacyServiceImpl pharmacyService;

    public PharmacyController(PharmacyServiceImpl pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/findPharmacies")
    public List<Pharmacy> findPharmacies(@RequestParam(required = false) String namePharmacy,
                           @RequestParam(required = false) String idMunicipality) {
        if(namePharmacy != null)
            return this.pharmacyService.findByName(namePharmacy);
        if(idMunicipality != null)
            return this.pharmacyService.findByMunicipalityId(Long.parseLong(idMunicipality)).
                    getPharmacies();
        return null;
    }

    @GetMapping("/api/findByMunicipality")
    @ResponseBody
    public List<Pharmacy> apiPharmaciesByMunicipality(@RequestParam(required = false) String idMunicipality) {
        return pharmacyService.findByMunicipalityId(Long.parseLong(idMunicipality)).getPharmacies();
    }

    @GetMapping("/api/findByName")
    @ResponseBody
    public List<Pharmacy> apiPharmaciesByName(@RequestParam(required = false) String namePharmacy) {
        return pharmacyService.findByName(namePharmacy);
    }

}
