package dians.project.pharmacies.pharmaciesmicro.controller;

import dians.project.pharmacies.pharmaciesmicro.VO.Municipality;
import dians.project.pharmacies.pharmaciesmicro.VO.Pharmacy;
import dians.project.pharmacies.pharmaciesmicro.VO.ResponseTemplateVO;
import dians.project.pharmacies.pharmaciesmicro.service.PharmaciesServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pharmacies")
public class PharmaciesController {

    public final PharmaciesServiceImpl pharmaciesService;

    public PharmaciesController(PharmaciesServiceImpl pharmaciesService) {
        this.pharmaciesService = pharmaciesService;
    }

    @GetMapping("/home")
    public String homePage(@RequestParam(required = false) String namePharmacy,
                           @RequestParam(required = false) String idMunicipality,
                           Model model) {
        if(namePharmacy != null) {
            model.addAttribute("pharmacies", pharmaciesService.findByName(namePharmacy).
                    getPharmacies());
        }
        if(idMunicipality != null)
            model.addAttribute("pharmacies",
                    pharmaciesService.findByMunicipality(Long.parseLong(idMunicipality)).getPharmacies());
        model.addAttribute("municipalities",
                pharmaciesService.findAllMunicipalities().getMunicipalities());
        return "homePage";
    }


    @GetMapping("/aboutUsPage")
    public String aboutUsPage() {
        return "aboutUsPage";
    }

    @GetMapping("/api/findByMunicipality")
    @ResponseBody
    public Pharmacy[] apiPharmaciesByOpstina(@RequestParam(required = false)
    String idMunicipality) {
        return pharmaciesService.findByMunicipalityApi(Long.parseLong(idMunicipality)).getPharmacies();
    }

    @GetMapping("/api/findByName")
    @ResponseBody
    public Pharmacy[] apiPharmaciesByName(@RequestParam(required = false) String namePharmacy) {
        return pharmaciesService.findByName(namePharmacy).getPharmacies();
    }

}
