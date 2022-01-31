package dians.project.pharmacies.pharmaciesmicro.VO;

import lombok.Data;

@Data
public class Pharmacy {

    private long id;

    private String name;

    private double coordinatesLon;

    private double coordinatesLat;

    private String address;

    private String workingHours;

    private Long municipalityId;

    public Pharmacy() {
    }

    public Pharmacy(String name, double coordinatesLon,
                    double coordinatesLat, String workingHours, Long municipalityId) {
        this.name = name;
        this.municipalityId = municipalityId;
        this.coordinatesLon = coordinatesLon;
        this.coordinatesLat = coordinatesLat;
        this.workingHours = workingHours;
    }
}