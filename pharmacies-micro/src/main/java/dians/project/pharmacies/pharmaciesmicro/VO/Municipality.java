package dians.project.pharmacies.pharmaciesmicro.VO;

import lombok.Data;

@Data
public class Municipality {
    private long id;

    private String name;

    private double coordinatesLon;

    private double coordinatesLat;

    public Municipality(){}

    public Municipality(String name, double coordinatesLon, double coordinatesLat) {
        this.name = name;
        this.coordinatesLon = coordinatesLon;
        this.coordinatesLat = coordinatesLat;
    }
}
