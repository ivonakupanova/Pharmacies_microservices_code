package dians.project.pharmacies.pharmacy.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Pharmacy {
    @Id
    private long id;

    private String name;

    private double coordinatesLon;

    private double coordinatesLat;

    private String address;

    private String workingHours;

    @Column(name = "opstina_id")
    private Long municipalityId;


    public Pharmacy(){}

    public Pharmacy(String name, double coordinatesLon,
                    double coordinatesLat, String workingHours, Long municipalityId) {
        this.name = name;
        this.municipalityId = municipalityId;
        this.coordinatesLon = coordinatesLon;
        this.coordinatesLat = coordinatesLat;
        this.workingHours = workingHours;
    }
}
