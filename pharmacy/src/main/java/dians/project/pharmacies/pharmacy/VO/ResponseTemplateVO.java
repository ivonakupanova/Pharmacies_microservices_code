package dians.project.pharmacies.pharmacy.VO;

import dians.project.pharmacies.pharmacy.model.Pharmacy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private List<Pharmacy> pharmacies;
    private Municipality municipality;
}
