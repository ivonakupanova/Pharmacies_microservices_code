package dians.project.pharmacies.municipality.controller;
import dians.project.pharmacies.municipality.model.Municipality;
import dians.project.pharmacies.municipality.service.MunicipalityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class MunicipalityController {
    public final MunicipalityServiceImpl municipalityService;

    public MunicipalityController(MunicipalityServiceImpl municipalityService) {
        this.municipalityService = municipalityService;
    }

    @GetMapping("/getAllMunicipalities")
    public List<Municipality> getMunicipalities() {
        return municipalityService.findAll();
    }

    @GetMapping("/getMunicipality/{id}")
    public Municipality getMunicipality(@PathVariable(required = false) Long id) {
        return municipalityService.findById(id);
    }

}
